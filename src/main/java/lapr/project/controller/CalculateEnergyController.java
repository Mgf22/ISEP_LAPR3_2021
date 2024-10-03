package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Mateus Fernandes
 */
public class CalculateEnergyController {
    /**
     * Method that returns the energy necessary to supply for a container
     * @param res1 Thermical resistance of material 1
     * @param res2 Thermical resistance of material 2
     * @param res3 Thermical resistance of material 3
     * @param temp1 Tempreature inside
     * @param temp2 Temperature of the container
     * @param time Time of travel
     * @return returns the energy
     */
    public double getEnergy(double res1, double res2, double res3, int temp1, int temp2, int time) {
        return App.getInstance().getCompany().getEnergy().getEnergy(res1,res2,res3,temp1,temp2,time);
    }
}