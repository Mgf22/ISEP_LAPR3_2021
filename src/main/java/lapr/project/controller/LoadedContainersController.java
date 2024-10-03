package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Jorge Lima
 */
public class LoadedContainersController {
    /**
     * Method that gets the instance of the store and returns a list of the containers that will be unloaded from a specific ship in the next port
     * @param mmsi Ships MMSI
     * @return returns a list of the containers that will be unloaded from a specific ship in the next port
     */
    public String LoadedContainersController(int mmsi){
        return App.getInstance().getCompany().getLoadedContainers().getLoadedContainers(mmsi);
    }
}
