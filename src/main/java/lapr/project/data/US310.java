package lapr.project.data;

import java.io.IOException;
import java.sql.*;
/**
 * @author Jorge Lima
 *
 */
public class US310 {
    /**
     * Method that calls the Pl/SQL of US310
     *
     * @return returns string with the result
     */
    public String US310(int y, int m, int id){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL mapOccupationPort(?,?,?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setInt(1,y);
                cs.setInt(2,m);
                cs.setInt(3,id);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.execute();
                return cs.getString(4);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
