package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.model.store.PortStore;
import lapr.project.model.store.ShipStore;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Jorge Lima
 */

public class FindPortController {
    private KdTree<Ports> kd;
    private Map<ShipStatic, BST<ShipDynamic>> mapa;

    /**
     * Method that gets the instance of the stores
     */
    public FindPortController() {
        Company c = App.getInstance().getCompany();
        PortStore b = c.getPortStore();
        kd = b.getPortStore();
        ShipStore a = c.getShipStore();
        mapa = a.getShipStore();
    }

    /**
     * Method to get the nearest port of a ship at a specific date
     *
     * @param code Ship Call Sign
     * @param data Date to get the ships nearest port
     * @return returns the nearest port of a ship at a specific date
     */
    public String getPorts(String code, Date data){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String str = "";
        for(Map.Entry<ShipStatic, BST<ShipDynamic>> key : mapa.entrySet()) {
            if(code.equals(key.getKey().getCallSign())){
                List<ShipDynamic> list = (List<ShipDynamic>) key.getValue().inOrder();
                for(int i = 1; i < list.size(); i++){
                    if(list.get(i).getBaseDateTime().compareTo(data) == 0){
                        str = "Date: " + dateFormat.format(list.get(i).getBaseDateTime()) + ", " + kd.findNearestNeighbour(list.get(i).getLAT(), list.get(i).getLON()).toString();
                    }
                }
                return str;
            }
        }
        return "Ship does not exist";
    }
}