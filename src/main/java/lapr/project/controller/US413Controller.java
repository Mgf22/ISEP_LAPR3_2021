package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author João Rodrigues
 */
public class US413Controller {
    /**
     * Method that gets the required energy to feed a set of refrigerated containers
     * @param contentores1 number of containers refrigerated at 7ºC
     * @param contentores2 number of containers refrigerated at -5ºC
     * @return  returns the needed energy to feed a set of refrigerated containers
     */
    public String getTotalEnergy(int contentores1, int contentores2) {
        return App.getInstance().getCompany().getTotalEnergy().getTotalEnergy(contentores1,contentores2);
    }
}
