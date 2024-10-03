package lapr.project.data;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Jorge Lima
 */
public class US406 {
    /**
     * Method that returns ships voyages with occupancy rate below a certain treeshold
     * @param a Percentage
     * @return returns ships voyages with occupancy rate below a certain treeshold
     */
    public String getUs406(int a){
        String ret = "";

        if(a < 66){
            a = 66;
        }

        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL US406(?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setInt(1,a);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.execute();
                return cs.getString(2);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
