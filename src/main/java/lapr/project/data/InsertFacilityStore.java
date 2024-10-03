package lapr.project.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author Jorge Lima
 */
public class InsertFacilityStore {
    /**
     * Method that reads the ports
     *
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean readFacility() {
        Path pathToFile = Paths.get("src/main/java/lapr/project/csv/bports.csv");
        String line;
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            while (line != null){
                atributes = line.split(",");
                getInsertFacility(Integer.parseInt(atributes[2]),atributes[3],Float.parseFloat(atributes[5]),Float.parseFloat(atributes[4]),atributes[1],1,400);
                line = br.readLine();
            }
        }catch (IOException | NumberFormatException ioe){
            return false;
        }
        return true;
    }
    /**
     * Method that gets the occupancy rate of a ship in a given manifest
     *
     * @return returns the occupancy rate of a ship in a given manifest
     */
    public void getInsertFacility(int id_facility, String name, float lon, float lat, String country, int id_type_facility, int capacity){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "INSERT INTO Facility(id_facility,name,lon,lat,id_country,id_type_facility,capacity) VALUES ("+id_facility+",'"+name+" Port',"+lon+","+lat+",(SELECT id_country from Country where country ='"+country+"'),"+id_type_facility+","+capacity+")";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
