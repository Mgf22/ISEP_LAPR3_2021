package lapr.project.model;
/**
 * @author Jorge Lima
 */
public class PortsGraph{
    private String type;
    private String name;
    private String continent;
    private String country;
    private double lon;
    private double lat;
    private int color;
    /**
     * Constructor method
     *
     * @param type Capital or port
     * @param name Name of capital or port
     * @param continent Continent where port or capital is located
     * @param country Country where port or capital is located
     * @param lat Latitude of the location
     * @param lon Longitude of the location
     */
    public PortsGraph(String type, String name, String continent, String country, double lon, double lat) {
        this.type = type;
        this.name = name;
        this.continent = continent;
        this.country = country;
        this.lon = lon;
        this.lat = lat;
        color = -1;
    }
    /**
     * Method that returns the type
     *
     * @return returns type of info (Capital or Port)
     */
    public String getType() {
        return type;
    }
    /**
     * Method that returns the name
     *
     * @return returns name
     */
    public String getName() {
        return name;
    }
    /**
     * Method that returns the continent
     *
     * @return returns continent of the location
     */
    public String getContinent() {
        return continent;
    }
    /**
     * Method that returns the longitude
     *
     * @return returns longitude of the location
     */
    public double getLon() {
        return lon;
    }
    /**
     * Method that returns the latitude
     *
     * @return returns latitude of the location
     */
    public double getLat() {
        return lat;
    }
    /**
     * Method that returns the color used in the graph
     *
     * @return returns color used in the graph
     */
    public int getColor() {
        return color;
    }
    /**
     * Method that sets the color in the graph
     */
    public void setColor(int color) {
        this.color = color;
    }
    /**
     * Method that returns the country
     *
     * @return returns country
     */
    public String getCountry() {
        return country;
    }
    /**
     * Method that checks if a vertex is already colored or not
     *
     * @return returns true if color is not -1
     */
    public boolean isColored() {
        return color != -1;
    }

    /**
     * Method that returns toString
     *
     * @return returns string
     */
    @Override
    public String toString() {
        return "PortsGraph: Type = " + type + ", Name = " + name;
    }

    /**
     * Method that checks if 2 objects of type PortsGraph are equal
     *
     * @param o object that will be compared
     * @return returns true if equal and false if not
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof PortsGraph)) {
            return false;
        }
        PortsGraph c = (PortsGraph) o;
        return this.type.compareTo(c.type) == 0 && this.name.compareTo(c.name) == 0;
    }
}
