package lapr.project.controller;

import lapr.project.model.App;
/**
 * @author João Rodrigues
 */
public class Us405Controller {
    /**
     * Method that gets the and returns  the occupancy rate per cargo manifest of a given ship on a given date
     * @param date Data
     * @param mmsi Ship mmsi
     * @return ocuppancy rate per cargo manifest
     */
    public String getUS405(String date,int mmsi) {
        return App.getInstance().getCompany().getUS405().getOccupancyRateManifest(date,mmsi);
    }
}

