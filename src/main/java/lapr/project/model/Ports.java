package lapr.project.model;
/**
 * @author Mateus Fernandes
 */
public class Ports {
    private int idPort;
    private String name;
    private double lat;
    private double lon;
    private String continent;
    private String country;
    /**
     * Constructor method
     *
     * @param lat Latitude of port
     * @param lon Longitude of port
     * @param continent Continent where port is located
     * @param country Country where port is located
     * @param idPort Identification of the port
     * @param name Name of the port
     */
    public Ports(int idPort, String name, double lat, double lon, String continent, String country) {
        this.idPort = idPort;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.continent = continent;
        this.country = country;
    }
    /**
     * Method that returns port info in string
     * @return string with all the info
     */
    @Override
    public String toString() {
        return "Port: IdPort = " + idPort + ", Name = " + name + ", Latitude = " + lat + ", Longitude = " + lon + ", Continent = " + continent + ", Country = " + country;
    }
}
