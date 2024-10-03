package lapr.project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Jorge Lima
 */
public class LoadedContainers {
    /**
     * Method that gets a list of all unloaded containers in the next port
     *
     * @param mmsi MMSI of the ship
     * @return returns a list of all unloaded containers in the next port
     */
    public String getLoadedContainers(int mmsi){
        String ret = "Informação indisponível.";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "SELECT f.name name, m.id_manifest_lu manifest " +
                    "FROM Manifest_load_unload m, Type_manifest tm, Facility f, Manifest_travel mt, Ship s, Vehicle v " +
                    "WHERE m.id_type_manifest = tm.id_type_manifest AND tm.type_manifest = 'Load' AND m.date_manifest > CURRENT_DATE AND f.id_facility = m.id_facility AND mt.id_manifest_travel = m.id_manifest_travel AND mt.id_vehicle = v.id_vehicle AND v.id_vehicle = s.id_vehicle AND s.id_mmsi = '" + mmsi +
                    "' ORDER BY m.date_manifest ASC";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if(rs.next() == true){
                        ret = "Port: " + rs.getString(1) + "\n";
                        sql = "SELECT c.iso_code iso, tr.type_refrigeration type, cm.position pos, c.payload " +
                                "FROM Container_manifest cm, Container c, Type_refrigeration tr " +
                                "WHERE cm.id_container = c.id_container AND c.id_type_refrigeration = tr.id_type_refrigeration AND cm.id_manifest_lu = "+ rs.getString(2);
                        try (PreparedStatement ps1 = con.prepareStatement(sql)) {
                            try (ResultSet rs1 = ps1.executeQuery()) {
                                while(rs1.next()){
                                    ret += "ISO: " + rs1.getString(1) + ", Refrigeration type: " + rs1.getString(2) + ", Position: " + rs1.getString(3) + ", Payload: " + rs1.getString(4) + "\n";
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
