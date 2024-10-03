package lapr.project.data;

import java.io.IOException;
import java.sql.*;
/**
 * @author Mateus Fernandes
 *
 */
public class OccupancyWarehouseStore {
    /**
     * Method that calls the Pl/SQL of US312
     *
     * @return returns string with the result
     */
    public String getOccupancyWarehouse(){
        String res = "";
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();

            String sql = "CALL OccupancyWare('') INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.registerOutParameter(1, Types.VARCHAR);
                cs.execute();
                res += cs.getString(1);
            }

            sql = "CALL CountContainer('') INTO ?";

            try(CallableStatement cs = con.prepareCall(sql)){
                cs.registerOutParameter(1, Types.VARCHAR);
                cs.execute();
                res += cs.getString(1);
                return res;
            }
        } catch (IOException | SQLException e) {
            return e.toString();
        }
    }
}
