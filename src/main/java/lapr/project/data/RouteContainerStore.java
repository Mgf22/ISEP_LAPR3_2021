package lapr.project.data;

import java.io.IOException;
import java.sql.*;
/**
 * @author Mateus Fernandes
 *
 */
public class RouteContainerStore {
    /**
     * Method that calls the Pl/SQL of US312
     *
     * @return returns string with the result
     */
    public String getRouteContainer(int id_cl, String id_cont){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL ROUTECONTAINER(?,?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setInt(1,id_cl);
                cs.setString(2,id_cont);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.execute();
                return cs.getString(3);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
