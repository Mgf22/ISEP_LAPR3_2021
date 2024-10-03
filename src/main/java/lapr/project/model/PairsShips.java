package lapr.project.model;
/**
 * @author Jorge Lima
 */
public class PairsShips implements Comparable<PairsShips>{
    private int mmsi1;
    private int mmsi2;
    private double dist1;
    private double dist2;
    private int moves1;
    private double travelDist1;
    private int moves2;
    private double travelDist2;

    /**
     * Constructor method
     *
     * @param d1 distance between departure ports of both ships
     * @param d2 distance between arrival ports of both ships
     * @param m1 mmsi of first ship
     * @param m2 mmsi of second ship
     * @param mov1 number of moves of first ship
     * @param mov2 number of moves of second ship
     * @param trav1 distance travelled by first ship
     * @param trav2 distance travelled by second ship
     */

    public PairsShips(int m1, int m2, double d1, double d2, int mov1, int mov2, double trav1, double trav2) {
        mmsi1 = m1;
        mmsi2 = m2;
        dist1 = d1;
        dist2 = d2;
        moves1 = mov1;
        moves2 = mov2;
        travelDist1 = trav1;
        travelDist2 = trav2;
    }
    /**
     * Method that returns mmsi of first ship
     *
     * @return returns mmsi of first ship
     */
    public int getMmsi1() {
        return mmsi1;
    }
    /**
     * Method that returns mmsi of second ship
     *
     * @return returns mmsi of second ship
     */
    public int getMmsi2() {
        return mmsi2;
    }
    /**
     * Method that returns distance between departure ports of both ships
     *
     * @return returns distance between departure ports of both ships
     */
    public double getDist1() {
        return dist1;
    }
    /**
     * Method that returns distance between arrival ports of both ships
     *
     * @return returns distance between arrival ports of both ships
     */
    public double getDist2() {
        return dist2;
    }
    /**
     * Method that returns number of moves of first ship
     *
     * @return returns number of moves of first ship
     */
    public int getMoves1() {
        return moves1;
    }
    /**
     * Method that returns distance travelled by first ship
     *
     * @return returns travelled distance by first ship
     */
    public double getTravelDist1() {
        return travelDist1;
    }
    /**
     * Method that returns number of moves of second ship
     *
     * @return returns number of moves of second ship
     */
    public int getMoves2() {
        return moves2;
    }
    /**
     * Method that returns distance travelled by second ship
     *
     * @return returns distance travelled by second ship
     */
    public double getTravelDist2() {
        return travelDist2;
    }
    /**
     * Method that compares 2 ships
     *
     * @param o Ship that will be compared
     * @return returns 1 if travelled distance is bigger, -1 if is smaller and 0 if is equal
     */
    @Override
    public int compareTo(PairsShips o) {
        if (travelDist2 < o.getTravelDist2()) {
            return 1;
        } else if (travelDist2 > o.getTravelDist2()) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
     * Method that returns all class info in string
     */
    @Override
    public String toString() {
        return "PairsShips{MMSI1 = " + mmsi1 + ", MMSI2 = " + mmsi2 + ", distOrig = " + dist1 + ", distDest = " + dist2 + ", moves1 = " + moves1 + ", travelDist1 = " + travelDist1 + ", moves2 = " + moves2 + ", travelDist2 = " + travelDist2 + '}';
    }
}
