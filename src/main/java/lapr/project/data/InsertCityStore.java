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
public class InsertCityStore {
    /**
     * Method that reads the ports
     *
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean readCity() {
        Path pathToFile = Paths.get("src/main/java/lapr/project/csv/countries.csv");
        String line;
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            int id_city = 1;
            int id_country = 1;
            while (line != null){
                atributes = line.split(",");
                getInsertCity(id_city,atributes[5],id_country);
                line = br.readLine();
                id_city++;
                id_country++;
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
    public void getInsertCity(int id_city, String city,int id_country){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "INSERT INTO City(id_city,city,id_country,capital) VALUES (" +id_city+ ",'" +city+ "'," +id_country+ ",'Y')";
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
