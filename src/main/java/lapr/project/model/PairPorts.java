package lapr.project.model;
/**
 * @author Jorge Lima
 */
public class PairPorts implements Comparable<PairPorts>{
    private String port1;
    private String port2;
    private String country1;
    private String country2;
    private int distance;
    /**
     * Constructor method
     *
     * @param port1 Name of port 1
     * @param port2 Name of port 2
     * @param country1 Country of port 1
     * @param country2 Country of port 2
     * @param distance Distance between both ports
     */
    public PairPorts(String port1, String port2, String country1, String country2, int distance) {
        this.port1 = port1;
        this.port2 = port2;
        this.country1 = country1;
        this.country2 = country2;
        this.distance = distance;
    }
    /**
     * Method that returns port 1
     *
     * @return returns port 1
     */
    public String getPort1() {
        return port1;
    }
    /**
     * Method that returns port 2
     *
     * @return returns port 2
     */
    public String getPort2() {
        return port2;
    }
    /**
     * Method that returns country of port 1
     *
     * @return returns country of port 1
     */
    public String getCountry1() {
        return country1;
    }
    /**
     * Method that returns country of port 2
     *
     * @return returns country of port 2
     */
    public String getCountry2() {
        return country2;
    }
    /**
     * Method that returns distance between both ports
     *
     * @return returns distance between ports
     */
    public int getDistance() {
        return distance;
    }
    /**
     * Method that compares 2 objects of type PairPorts
     *
     * @param o object that will be compared
     * @return returns 1 if distance is bigger, -1 if distance is smaller and 0 if distances are equal
     */
    @Override
    public int compareTo(PairPorts o){
        if(distance > o.getDistance()){
            return 1;
        }else if(distance < o.getDistance()){
            return -1;
        }else{
            return 0;
        }
    }
}