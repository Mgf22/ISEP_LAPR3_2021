package lapr.project.model.store;

import lapr.project.model.BST;
import lapr.project.model.ShipDynamic;
import lapr.project.model.ShipStatic;

import java.util.*;

/**
 * @author Mateus Fernandes
 */
public class ShipStore {
    private Map<ShipStatic, BST<ShipDynamic>> mapa;
    /**
     * Constructor method
     */
    public ShipStore(){
        mapa = new HashMap<>();
    }
    /**
     * Method that returns a map with the ships in the store
     */
    public Map<ShipStatic, BST<ShipDynamic>> getShipStore(){
        return mapa;
    }
    /**
     * Method to insert ships in the store. Returns map with all ships
     *
     * @param dynamic Class with all dynamic values of ship
     * @param sta Class with all static values of ship
     */
    public Map<ShipStatic, BST<ShipDynamic>> insert(ShipStatic sta, ShipDynamic dynamic){
        BST<ShipDynamic> bt;
        boolean flag = false;
        for(Map.Entry<ShipStatic, BST<ShipDynamic>> a : mapa.entrySet()) {
            if(sta.getMmsi() == a.getKey().getMmsi()){
                bt = mapa.get(a.getKey());
                bt.insert(dynamic);
                flag = true;
                break;
            }
        }
        if(!flag){
            bt = new BST<>();
            bt.insert(dynamic);
            mapa.put(sta,bt);
        }
        return mapa;
    }
}
