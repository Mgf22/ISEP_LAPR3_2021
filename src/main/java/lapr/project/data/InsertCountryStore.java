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
public class InsertCountryStore {
    /**
     * Method that reads the ports
     *
     * @return returns a boolean that shows if the data was read with success
     */
    public boolean readCountry() {
        Path pathToFile = Paths.get("src/main/java/lapr/project/csv/countries.csv");
        String line;
        String [] atributes;

        try (BufferedReader br = Files.newBufferedReader(pathToFile)){
            line = br.readLine();
            line = br.readLine();
            int id_country = 47;
            while (line != null){
                atributes = line.split(",");
                getInsertCountry(id_country,atributes[3],2,Float.parseFloat(atributes[4]),Float.parseFloat(atributes[6]),Float.parseFloat(atributes[7]),atributes[1],atributes[2]);
                line = br.readLine();
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
    public void getInsertCountry(int id_country, String country, int id_continent, float population, float lat, float lon, String alpha_code_2, String alpha_code_3 ){
        try{
            DatabaseConnection dbc = ConnectionFactory.getInstance().getDatabaseConnection();
            Connection con = dbc.getConnection();
            String sql = "INSERT INTO Country(id_country,country,id_continent,population,lat,lon,alpha_code_2,alpha_code_3) VALUES (" + id_country + ", '" + country + "', " + id_continent + ", "+population+", " + lat + ", " + lon + ", '" + alpha_code_2 + "', '" + alpha_code_3 + "')";
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