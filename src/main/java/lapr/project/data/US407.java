package lapr.project.data;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Jorge Lima
 */
public class US407 {
    /**
     * Method that returns the next seven days map of loads and unloads
     * @param date Date
     * @return returns next seven days map of loads and unloads
     */
    public String getUs407(String date){
        String ret = "";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL US407(?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setString(1,date);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.execute();
                return cs.getString(2);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
