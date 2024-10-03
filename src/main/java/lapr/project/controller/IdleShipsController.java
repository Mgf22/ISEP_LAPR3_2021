package lapr.project.controller;

import lapr.project.model.App;

/**
 * @author Mateus Fernandes
 */
public class IdleShipsController {
    /**
     * Method that gets the instance of the store and returns the days a ship has been idle
     * @param ano Year
     * @param id_mmsi MMSI of the ship
     * @return returns the days a ship has been idle
     */
    public String getIdleShip(int ano, String id_mmsi){
        return App.getInstance().getCompany().getIdleShipStore().getIdleShip(ano,id_mmsi);
    }
}
