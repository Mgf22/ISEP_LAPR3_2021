package lapr.project.data;
/**
 * @author Mateus Fernandes
 */
public class CenterOfMassStore {
    /**
     * Method that returns the center of mass of a ship
     * @param area1 Area of first triangle
     * @param area2 Area of rectangle
     * @param area3 Area of second triangle
     * @param pos1 Position of first triangle
     * @param pos2 Position of rectangle
     * @param pos3 Position of second triangle
     * @return returns the center of mass
     */
    public double getCenterOfMass(int area1, int area2, int area3, int pos1, int pos2, int pos3){
        double res = 0;
        double areatotal = 0;
        areatotal = area1 + area2 + area3;
        res = (area1/areatotal)*pos1 + (area2/areatotal)*pos2 + (area3/areatotal)*pos3;
        return res;
    }
}