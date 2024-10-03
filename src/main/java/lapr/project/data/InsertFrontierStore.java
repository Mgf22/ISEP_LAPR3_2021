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
public class InsertFrontierStore {
    /**
     * Method that reads the ports
     *
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean readFrontier() {
        Path pathToFile = Paths.get("src/main/java/lapr/project/csv/borders.csv");
        String line;
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            while (line != null){
                atributes = line.split(",");
                getInsertFrontier(atributes[0],atributes[1]);
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
    public void getInsertFrontier(String country1, String country2){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "INSERT INTO Frontier (id_country_1,id_country_2) VALUES ((select id_country from country where country = '"+country1+"'),(select id_country from country where country = '"+country2+"'))";
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
