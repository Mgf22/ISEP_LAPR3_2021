package lapr.project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Mateus Fernandes
 */
public class AvailableShipStore {
    /**
     * Method that gets all the available ships on a certain date and their location
     *
     * @param baseDateTime Monday of next week
     * @return returns string with all the available ships on a certain date and their location
     */
    public String getAvailableShip(String baseDateTime){
        String ret = "";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "SELECT id_mmsi,lat,lon " +
                    "FROM Ship_Dynamic " +
                    "WHERE next_Day('" + baseDateTime + "','Segunda-feira') = date_time AND lat IN (SELECT lat FROM Facility) AND lon IN (SELECT lon FROM Facility)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){
                        ret += "MMSI: " + rs.getString(1) + " Latitude: " + rs.getString(2) + " Longitude: " + rs.getString(3) + "\n";
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
