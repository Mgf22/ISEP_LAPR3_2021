package lapr.project.model;
/**
 * @author Mateus Fernandes
 */

public class ShipStatic {
    private int mmsi;
    private String vesselName;
    private String imo;
    private String callSign;
    private int vesselType;
    private int length;
    private int width;
    private float draft;
    private String cargo;
    /**
     * Constructor method
     *
     * @param callSign Call sign of the ship
     * @param cargo Cargo of the ship
     * @param draft Draft of the ship
     * @param imo IMO of the ship
     * @param length Length of the ship
     * @param mmsi MMSI of the ship
     * @param vesselName Name of the ship
     * @param vesselType Ship type
     * @param width Width of the ship
     */
    public ShipStatic(int mmsi, String vesselName, String imo, String callSign, int vesselType, int length, int width, float draft, String cargo) {
        this.mmsi = mmsi;
        this.vesselName = vesselName;
        this.imo = imo;
        this.callSign = callSign;
        this.vesselType = vesselType;
        this.length = length;
        this.width = width;
        this.draft = draft;
        this.cargo = cargo;
    }
    /**
     * Method that returns the MMSI of the ship
     *
     * @return returns mmsi of ship
     */
    public int getMmsi() {
        return mmsi;
    }
    /**
     * Method that returns the IMO of the ship
     *
     * @return returns imo of ship
     */
    public String getImo() {
        return imo;
    }
    /**
     * Method that returns the Call Sign of the ship
     *
     * @return returns call sign of ship
     */
    public String getCallSign() {
        return callSign;
    }
    /**
     * Method that returns ships info in string
     *
     * @return returns string with ship's info
     */
    @Override
    public String toString() {
        return "Ship_static{ MMSI = " + mmsi + ", Vessel Name = " + vesselName + ", IMO = " + imo + ", Call Sign = " + callSign + ", Vessel Type = " + vesselType + ", Length = " + length + ", Width = " + width + ", Draft = " + draft + ", Cargo = " + cargo + '}';
    }
}