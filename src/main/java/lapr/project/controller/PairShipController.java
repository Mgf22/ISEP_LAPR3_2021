package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.BST;
import lapr.project.model.ShipDynamic;
import lapr.project.model.ShipStatic;
import lapr.project.model.store.ShipStore;
import java.util.List;
import java.util.Map;

/**
 * @author Jorge Lima
 */

public class PairShipController {
    Map<ShipStatic, BST<ShipDynamic>> mapa;
    /**
     * Method that gets the instance of the stores
     */
    public PairShipController() {
        ShipStore a = App.getInstance().getCompany().getShipStore();
        mapa = a.getShipStore();
    }
    /**
     * Method that gets pairs of ships whith close departures and arrivals
     *
     * @return returns a string with all ships with close departures and arrivals
     */
    /*
    public String filterList(){
        PairsShips n;
        BST<PairsShips> arv = new BST<>();
        int k = 0;
        int j = 0;

        for(Map.Entry<ShipStatic, BST<ShipDynamic>> key : mapa.entrySet()) {
            k++;
            for(Map.Entry<ShipStatic, BST<ShipDynamic>> key1 : mapa.entrySet()) {
                j++;
                if(j > k && key.getKey().getMmsi() != key1.getKey().getMmsi()){
                    double distS = distance(key.getValue().smallestElement().getLAT(),key1.getValue().smallestElement().getLAT(),key.getValue().smallestElement().getLON(),key1.getValue().smallestElement().getLON());
                    double distB = distance(key.getValue().biggestElement().getLAT(),key1.getValue().biggestElement().getLAT(),key.getValue().biggestElement().getLON(),key1.getValue().biggestElement().getLON());
                    double distTotal1 = distTotal(key.getValue());
                    double distTotal2 = distTotal(key1.getValue());

                    if(distS <= 5000 && distB <= 5000 && distTotal1 != distTotal2 && distTotal1 >= 10000 && distTotal2 >= 10000){
                        n = new PairsShips(key.getKey().getMmsi(), key1.getKey().getMmsi(), distS, distB, key.getValue().size(),key1.getValue().size(), distTotal1,distTotal2);
                        arv.insert(n);
                    }
                }
            }
            j = 0;
        }
        List<PairsShips> list = (List<PairsShips>) arv.inOrder();
        StringBuilder bld = new StringBuilder();
        for (PairsShips pairsShips : list) {
            bld.append(pairsShips.toString()).append("\n");
        }
        return bld.toString();
    }*/
    /**
     * Method that calculates the distance between 2 points
     *
     * @param lat1 Latitude of the first point
     * @param lat2 Latitude of the second point
     * @param long1 Longitude of the first point
     * @param long2 Longitude of the second point
     * @return returns the distance between 2 points
     */
    public double distance(double lat1, double lat2, double long1, double long2){
        double difLat;
        double difLong;
        double a;
        double c;
        double d;
        double r = 6371000;

        difLat = (lat2-lat1) * (3.1416/180);
        difLong = (long2-long1) * (3.1416/180);
        lat1 = lat1 * (3.1416/180);
        lat2 = lat2 * (3.1416/180);

        a = Math.sin(difLat/2) * Math.sin(difLat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(difLong/2) * Math.sin(difLong/2);
        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        d = r * c; // in metres

        return Math.round(d*100.0)/100.0;
    }

    /**
     * Method that calculates the distance that was travelled by a ship
     *
     * @param a Tree with points of the ships travel
     * @return returns the distance travelled by a ship
     *//*
    public double distTotal(BST<ShipDynamic> a){
        List<ShipDynamic> list = (List<ShipDynamic>) a.inOrder();
        double dist = 0;

        for(int i = 1; i < list.size(); i++){
            dist += distance(list.get(i-1).getLAT(), list.get(i).getLAT(), list.get(i-1).getLON(), list.get(i-1).getLON());
        }

        return Math.round(dist*100.0)/100.0;
    }*/
}