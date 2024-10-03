package lapr.project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Jorge Lima
 */
public class ManifestTransportStore {
    /**
     * Method that gets the occupancy rate of a ship in a given manifest
     *
     * @param ano ano específico dos manifestos
     * @param idCapitao Id do capitão que transportou os manifestos
     * @return returns the occupancy rate of a ship in a given manifest
     */
    public String getManifest(int idCapitao, int ano){
        Double ret = 0.0;
        Double ret1 = 0.0;
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "SELECT COUNT(cm.id_container) " +
                    "FROM Container_manifest cm " +
                    "WHERE cm.id_container IN (" +
                    "SELECT cm.id_container " +
                    "FROM Manifest_load_unload mlu, Manifest_travel mt, Type_manifest tm, Container_manifest cm, Vehicle v, Worker_vehicle wv " +
                    "WHERE mlu.id_type_manifest = tm.id_type_manifest " +
                    "AND tm.id_type_manifest = 1 " +
                    "AND cm.id_manifest_lu = mlu.id_manifest_lu " +
                    "AND mlu.id_manifest_travel = mt.id_manifest_travel " +
                    "AND mt.id_vehicle = v.id_vehicle " +
                    "AND v.id_vehicle = wv.id_vehicle " +
                    "AND wv.id_worker = " + idCapitao +
                    "AND mlu.date_manifest <= TO_DATE('" + ano + "-12-31','YYYY-MM-DD') AND mlu.date_manifest >= TO_DATE('" + ano + "-01-01','YYYY-MM-DD'))";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if(rs.next()){
                        ret = rs.getDouble(1);
                        sql = "SELECT COUNT (id_manifest_travel) " +
                                "FROM Manifest_travel mt, Vehicle v, Worker_vehicle wv " +
                                "WHERE (date_manifest >= TO_DATE('" + ano + "-01-01','YYYY-MM-DD') and date_manifest <= TO_DATE('" + ano + "-12-31','YYYY-MM-DD')) " +
                                "AND mt.id_vehicle = v.id_vehicle " +
                                "AND v.id_vehicle = wv.id_vehicle " +
                                "AND wv.id_worker = " + idCapitao;

                        try (PreparedStatement ps1 = con.prepareStatement(sql)) {
                            try (ResultSet rs1 = ps1.executeQuery()) {
                                if(rs1.next()){
                                    ret1 = rs1.getDouble(1);
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ret1 == 0){
            return "Containers: 0 Average per manifest: 0";
        }else{
            return "Containers: " + ret + " Average per manifest: " + ret/ret1;
        }
    }
}
