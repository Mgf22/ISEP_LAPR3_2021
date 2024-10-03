package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Jorge Lima
 */

public class OccupancyRateController {
    /**
     * Method that gets the instance of the store and returns the occupancy rate of a ship
     * @param mmsi Ships mmsi
     * @param id_manifest Identification of the manifest of the ship
     * @return returns the occupancy rate of a ship
     */
    public double getOccupancy(int mmsi, int id_manifest){
        return App.getInstance().getCompany().getOccupancyRateStore().getOccupancyRate(mmsi, id_manifest);
    }
}
