package lapr.project.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Jorge Lima
 */
public class OccupancyRateStore {
    /**
     * Method that gets the occupancy rate of a ship in a given manifest
     *
     * @param mmsi MMSI of the ship
     * @param id_manifest Identification of the manifest
     * @return returns the occupancy rate of a ship in a given manifest
     */
    public double getOccupancyRate(int mmsi, int id_manifest){
        double ret = 0;
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "SELECT (COUNT(id_container_manifest)/avg(capacity))*100 cont " +
                    "FROM Container_manifest cm, Ship s, Manifest_load_unload m, Vehicle v, Manifest_travel mt " +
                    "WHERE cm.id_manifest_lu = m.id_manifest_lu AND m.id_manifest_travel = mt.id_manifest_travel AND mt.id_vehicle = v.id_vehicle AND v.id_vehicle = s.id_vehicle AND s.id_mmsi = '" + mmsi + "' AND mt.id_manifest_travel =" + id_manifest;

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    ret = rs.getDouble("cont");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
