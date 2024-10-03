package lapr.project.data;

import java.io.IOException;
import java.sql.*;
/**
 * @author Mateus Fernandes
 *
 */
public class InvalidContainerStore {
    /**
     * Method that calls the Pl/SQL of US312
     *
     * @return returns string with the result
     */
    public String getInvalidContainer(String id_container, int id_client){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL DisplayWarning(?,?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setString(1,id_container);
                cs.setInt(2,id_client);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.execute();
                return cs.getString(3);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
