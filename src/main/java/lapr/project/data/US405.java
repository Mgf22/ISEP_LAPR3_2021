package lapr.project.data;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
/**
 * @author João Rodrigues
 */
public class US405 {
    /**
     * Method that returns the occupancy rate per cargo manifest of a given ship on a given date
     * @param date Date
     * @param mmsi Ship mmsi
     * @return returns the occupancy rate
     */
    public String getOccupancyRateManifest(String date, int mmsi){
        String ret = "";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL OccupancyManifest(?,?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setString(1,date);
                cs.setInt(2,mmsi);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.execute();
                return cs.getString(3);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}


