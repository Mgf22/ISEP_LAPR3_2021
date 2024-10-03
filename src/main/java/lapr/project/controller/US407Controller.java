package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Jorge Lima
 */
public class US407Controller {
    /**
     * Method that returns the next seven days map of loads and unloads
     * @param date Data
     * @return returns the next seven days map of loads and unloads
     */
    public String getUS407(String date) {
        return App.getInstance().getCompany().getUs407().getUs407(date);
    }
}
