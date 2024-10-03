package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Jorge Lima
 */
public class US406Controller {
    /**
     * Method that returns ships voyages with occupancy rate below a certain treeshold
     * @param a Percentage
     * @return returns ships voyages with occupancy rate below a certain treeshold
     */
    public String getUS406(int a) {
        return App.getInstance().getCompany().getUs406().getUs406(a);
    }
}
