package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.store.GraphStore;
/**
 * @author Jorge Lima
 */
public class ReadGraphController {
    GraphStore a;
    /**
     * Constructor method that gets the store
     *
     */
    public ReadGraphController(){
        a = App.getInstance().getCompany().getGraphStore();
    }
    /**
     * Method that calls the method that reads all the information and puts it into the graph
     *
     * @return returns true if the information was read and false if not
     */
    public boolean read(int n){
        return (a.consGraph(n) != null);
    }
}
