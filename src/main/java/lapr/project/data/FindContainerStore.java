package lapr.project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Jorge Lima
 */
public class FindContainerStore {
    /**
     * Method that gets the occupancy rate of a ship in a given manifest
     *
     * @param id ID of container
     * @return returns the occupancy rate of a ship in a given manifest
     */
    public String getContainer(String id){
        String str = "Informação inválida.";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "SELECT f.name " +
                    "FROM Container c, Container_manifest cm, Manifest_load_unload mlu, Facility f, Type_manifest tm " +
                    "WHERE c.id_container = cm.id_container AND cm.id_manifest_lu = mlu.id_manifest_lu " +
                    "AND mlu.id_facility = f.id_facility AND mlu.id_type_manifest = tm.id_type_manifest " +
                    "AND tm.id_type_manifest = 2 AND c.id_container = '" + id + "' AND mlu.date_manifest <= CURRENT_DATE";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if(rs.next()){
                        str = "Port, " + rs.getString(1);
                    }else{
                        sql = "SELECT s.ship_name " +
                                "FROM Container c, Container_manifest cm, Manifest_load_unload mlu, Ship_container sc, Vehicle v, Ship s, Type_manifest tm " +
                                "WHERE c.id_container = cm.id_container AND cm.id_manifest_lu = mlu.id_manifest_lu " +
                                "AND mlu.id_type_manifest = tm.id_type_manifest AND tm.id_type_manifest = 1 " +
                                "AND cm.id_container_manifest = sc.id_container_manifest AND sc.id_vehicle = v.id_vehicle " +
                                "AND v.id_vehicle = s.id_vehicle AND c.id_container = '" + id + "'";

                        try (PreparedStatement ps1 = con.prepareStatement(sql)) {
                            try (ResultSet rs1 = ps1.executeQuery()) {
                                if(rs1.next()) {
                                    str = "Ship, " + rs1.getString(1);
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
