package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Jorge Lima
 */
public class Us310Controller {
    /**
     * Method that gets the and returns the result of US310
     *
     */
    public String getUS310(int y, int m, int id) {
        return App.getInstance().getCompany().getUS310().US310(y,m,id);
    }
}
