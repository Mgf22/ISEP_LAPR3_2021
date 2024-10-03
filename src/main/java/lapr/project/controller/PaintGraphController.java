package lapr.project.controller;

import lapr.project.model.App;
import lapr.project.model.ColorGraph;
import lapr.project.model.store.GraphStore;
/**
 * @author Jorge Lima
 */
public class PaintGraphController {
    GraphStore a;
    /**
     * Constructor method that gets the store
     *
     */
    public PaintGraphController() {
         a = App.getInstance().getCompany().getGraphStore();
    }
    /**
     * Method that paints the graph
     *
     * @return returns true if graph was painted and false if not
     */
    public boolean paint(){
        ColorGraph b = new ColorGraph();
        b.paintGraph(a.getGraphStore());
        return true;
    }
}
