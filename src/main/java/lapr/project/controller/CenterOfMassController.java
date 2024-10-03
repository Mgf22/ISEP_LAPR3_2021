package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Mateus Fernandes
 */
public class CenterOfMassController {
    /**
     * Method that gets the instance of the store and returns the center of mass of a ship
     * @param area1 Area of first triangle
     * @param area2 Area of rectangle
     * @param area3 Area of second triangle
     * @param pos1 Position of first triangle
     * @param pos2 Position of rectangle
     * @param pos3 Position of second triangle
     * @return returns the center of mass
     */
    public double getCenterOfMass(int area1, int area2, int area3, int pos1, int pos2, int pos3) {
        return App.getInstance().getCompany().getCenterOfMassStore().getCenterOfMass(area1, area2, area3, pos1, pos2, pos3);
    }
}
