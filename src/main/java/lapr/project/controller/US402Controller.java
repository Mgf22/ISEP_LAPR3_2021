package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.PortsGraph;
import lapr.project.model.US402;
import lapr.project.model.store.GraphStore;

import java.util.LinkedList;

/**
 * @author Jorge Lima
 */
public class US402Controller {
    GraphStore a;
    /**
     * Constructor method that gets the store
     */
    public US402Controller() {
        a = App.getInstance().getCompany().getGraphStore();
    }

    public String landPath(PortsGraph start, PortsGraph end){
        US402 us402 = new US402();
        return returnString(us402.landPath(a.getGraphStore(), start, end), "land.");
    }

    public String maritimePath(PortsGraph start, PortsGraph end){
        US402 us402 = new US402();
        return returnString(us402.maritimePath(a.getGraphStore(), start, end), "sea.");
    }

    public String landMaritimePath(PortsGraph start, PortsGraph end){
        US402 us402 = new US402();
        return returnString(us402.landMaritimePath(a.getGraphStore(), start, end), "land or sea.");
    }

    private String returnString(LinkedList<PortsGraph> ll, String a){
        if(ll.isEmpty()){
            return "There is no path between the 2 ports by " + a;
        }else{
            String str = "";
            for(int i = 0; i < ll.size(); i++){
                if(i == ll.size()-1){
                    str += "Type: " + ll.get(i).getType() + ", Name: " + ll.get(i).getName();
                }else {
                    str += "Type: " + ll.get(i).getType() + ", Name: " + ll.get(i).getName() + " -> ";
                }
            }
            return str;
        }
    }
}
