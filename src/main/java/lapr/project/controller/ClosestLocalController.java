package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.ClosestLocal;
import lapr.project.model.PortsGraph;
import lapr.project.model.store.GraphStore;
import java.util.ArrayList;
import java.util.Map;
/**
 * @author Jorge Lima
 */
public class ClosestLocalController {
    GraphStore a;
    /**
     * Constructor method that gets the store
     *
     */
    public ClosestLocalController() {
        a = App.getInstance().getCompany().getGraphStore();
    }
    /**
     * Method that calculates the n closest ports or cities and returns a String
     *
     * @return returns string with n closest ports or cities
     */
    public String returnClosest(int n){
        String europa = "";
        String america = "";
	    ClosestLocal b = new ClosestLocal();
	    Map<PortsGraph, ArrayList<String>> mapa = b.returnClosest(a.getGraphStore(), n);

        for (Map.Entry<PortsGraph, ArrayList<String>> pg : mapa.entrySet()){
            if (pg.getKey().getContinent().equals("Europe")){
                europa += "Origin: " + pg.getKey().getName() + " (" + pg.getKey().getType() + ")\n";
                for(String str : pg.getValue()){
                    europa += "        " + str + "\n";
                }
            } else if (pg.getKey().getContinent().equals("America")){
                america += "Origin: " + pg.getKey().getName() + " (" + pg.getKey().getType() + ")\n";
                for(String str : pg.getValue()){
                    america += "        " + str + "\n";
                }
            }
        }
        return "Europa: \n" + europa + "\nAmerica:\n" + america;
    }
}