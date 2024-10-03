package lapr.project.data;
/**
 * @author Mateus Fernandes
 */
public class CalculateEnergyStore {
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
    public double getEnergy(double res1, double res2, double res3, int temp1, int temp2, int time){
        double res = 0;
        double restotal = 0;
        double pot = 0;
        restotal = res1 + res2 + res3;
        pot = (temp1-temp2)/restotal;
        res = pot*time;
        return res;
    }
}