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
public class InsertSeaDistStore {
    /**
     * Method that reads the ports
     *
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean readSeaDist() {
        Path pathToFile = Paths.get("src/main/java/lapr/project/csv/seadists.csv");
        String line;
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            while (line != null){
                atributes = line.split(",");
                getInsertSeaDist(Integer.parseInt(atributes[1]),Integer.parseInt(atributes[4]),Integer.parseInt(atributes[6]));
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
    public void getInsertSeaDist(int id_facility1, int id_facility2, int sea_dist){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "INSERT INTO Sea_dist(id_facility1,id_facility2,sea_dist) VALUES ("+id_facility1+","+id_facility2+","+sea_dist+")";
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