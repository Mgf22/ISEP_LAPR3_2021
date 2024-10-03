package lapr.project.model;

import lapr.project.model.graph.matrix.MatrixGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
/**
 * @author Jorge Lima & João Rodrigues
 *
 */
public class ColorGraph {
    /**
     * Method that paints the graph
     *
     * @param mapa Map of the graph
     */
    public void paintGraph(MatrixGraph<PortsGraph, Integer> mapa) {
        boolean[] colors = new boolean[mapa.numVertices()];
        int color;
        int n;
        ArrayList<PortsGraph> pgM = mapa.vertices();

        for (PortsGraph pg : pgM) {
            if (pg.getType().equals("Capital")) {
                Arrays.fill(colors, false);
                Collection<PortsGraph> pgAdj = mapa.adjVertices(pg);

                for (PortsGraph pgA : pgAdj) {
                    if (pgA.isColored()) {
                        colors[pgA.getColor()] = true;
                    }
                }

                color = -1;
                n = 0;
                while (color == -1){
                    if (!colors[n]) {
                        color = n;
                    }
                    n++;
                }
                pg.setColor(color);

                for (PortsGraph pgCountry : pgM) {
                    if (pgCountry.getCountry().equals(pg.getCountry())) {
                        pgCountry.setColor(color);
                    }
                }
            }
        }
    }
}