package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author Jorge Lima
 */
public class OccupancyRateTimeController {
    /**
     * Method that gets the instance of the store and returns the occupancy rate of a ship in a give date
     *
     * @param mmsi Ships mmsi
     * @param date Date where occupancy rate is measured
     * @return returns the occupancy rate of a ship in a give date
     */
    public double getOccupancy(int mmsi, String date){
        return App.getInstance().getCompany().getOccupancyRateTimeStore().getOccupancyRate(mmsi, date);
    }
}
