package lapr.project.model;

import java.util.Date;
/**
 * @author Mateus Fernandes
 */
public class ShipDynamic implements Comparable<ShipDynamic>{
    private Date baseDateTime;
    private float lat;
    private float lon;
    private float sog;
    private float cog;
    private int heading;
    private String transcieverClass;
    /**
     * Constructor method
     *
     * @param lon Longitude of ship location
     * @param lat Latitude of ship location
     * @param baseDateTime Date of when information was read
     * @param cog Cog of ship at that moment
     * @param heading Heading of the ship at that moment
     * @param sog Sog of the ship at that moment
     * @param transcieverClass Transceiver class of the ship
     */
    public ShipDynamic(Date baseDateTime, float lat, float lon, float sog, float cog, int heading, String transcieverClass) {
        this.baseDateTime = baseDateTime;
        this.lat = lat;
        this.lon = lon;
        this.sog = sog;
        this.cog = cog;
        this.heading = heading;
        this.transcieverClass = transcieverClass;
    }
    /**
     * Method that returns date and time of when the information in this class was read
     *
     * @return returns date of information
     */
    public Date getBaseDateTime() { return baseDateTime;}
    /**
     * Method that returns latitude of the ship
     *
     * @return returns latitude of ship
     */
    public float getLAT() {
        return lat;
    }
    /**
     * Method that returns longitude of the ship
     *
     * @return returns longitude of ship
     */
    public float getLON() { return lon; }
    /**
     * Method that compares 2 ships
     *
     * @param o Ship that will be compared
     * @return returns 1 if date is bigger, -1 if smaller and 0 if equal
     */
    @Override
    public int compareTo(ShipDynamic o) {
        if (baseDateTime.after(o.getBaseDateTime())) {
            return 1;
        } else if (baseDateTime.before(o.getBaseDateTime())) {
            return -1;
        } else {
            return 0;
        }
    }
}