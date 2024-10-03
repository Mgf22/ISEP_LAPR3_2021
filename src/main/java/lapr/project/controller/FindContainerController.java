package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Jorge Lima
 */
public class FindContainerController {
    /**
     * Method that gets the instance of the store and returns the occupancy rate of a ship
     * @param container ID of container
     * @return returns the occupancy rate of a ship
     */
    public String getContainer(String container){
        return App.getInstance().getCompany().getContainer().getContainer(container);
    }
}
