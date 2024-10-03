package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Mateus Fernandes
 */

public class OccupancyWarehouseController {
    /**
     * Method that gets the instance of the store and returns the occupancy rate of all Warehouses
     *
     */
    public String getOccupancyWarehouse() {
        return App.getInstance().getCompany().getOccupancyWarehouseStore().getOccupancyWarehouse();
    }
}
