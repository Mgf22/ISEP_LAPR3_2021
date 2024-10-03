package lapr.project.data;

import java.io.IOException;
import java.sql.*;

/**
 * @author Joao Rodrigues
 */
public class AuditTrailsStore {
    /**
     * Method that returns the operations made on a container
     * @param id_manifest_travel ID of the manifest
     * @param id_container ID of the container
     * @return returns the operations made on container
     */

    public String getAuditTrails(int id_manifest_travel, String id_container) {
        String ret = "";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL AudiTrails(?,?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setInt(1,id_manifest_travel);
                cs.setString(2,id_container);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.execute();
                return cs.getString(3);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
