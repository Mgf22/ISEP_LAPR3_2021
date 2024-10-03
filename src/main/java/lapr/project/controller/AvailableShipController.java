package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Mateus Fernandes
 */

public class AvailableShipController {
    /**
     * Method that gets the instance of the store and returns the list of a ships on a certain date and their location
     * @param baseDateTime Date of next Monday
     * @return returns string of the list of a ships on a certain date and their location
     */

    public String getAvailableShip(String baseDateTime){
        return App.getInstance().getCompany().getAvailableShipStore().getAvailableShip(baseDateTime);
    }
}

