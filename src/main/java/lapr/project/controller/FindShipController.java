package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.BST;
import lapr.project.model.ShipDynamic;
import lapr.project.model.ShipStatic;
import lapr.project.model.store.ShipStore;
import java.util.Map;

/**
 * @author Jorge Lima
 */
public class FindShipController {
    private Map<ShipStatic, BST<ShipDynamic>> mapa;

    /**
     * Method that gets the instance of the store
     */
    public FindShipController() {
        ShipStore a = App.getInstance().getCompany().getShipStore();
        mapa = a.getShipStore();
    }

    /**
     * Method to get a ship by MMSI or Call Sign or IMO
     *
     * @param code Ships MMSI or Call Sign or IMO
     * @return returns a ship by MMSI or Call Sign or IMO
     */
    public String getShips(String code){
        if (code.length() == 9){
            for(ShipStatic key : mapa.keySet()) {
                if(Integer.parseInt(code) == key.getMmsi()){
                    return key.toString();
                }
            }
        }else{
            for(ShipStatic key : mapa.keySet()) {
                if(code.equals(key.getImo()) || code.equals(key.getCallSign())){
                    return key.toString();
                }
            }
        }
        return "Ship does not exist";
    }
}