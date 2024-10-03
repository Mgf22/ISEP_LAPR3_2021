package lapr.project.data;

import java.io.IOException;
import java.sql.*;

/**
 * @author Mateus Fernandes
 */
public class IdleShipsStore {
    /**
     * Method that returns the number of a days a ship has been idle
     * @param ano Year
     * @param id_mmsi MMSI of the ship
     * @return returns the number of a days a ship has been idle
     */

    public String getIdleShip(int ano, String id_mmsi) {
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL IdleDays(?,?) INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.setInt(1,ano);
                cs.setString(2,id_mmsi);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.execute();
                return cs.getString(3);
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
