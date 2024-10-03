package lapr.project.model;

import lapr.project.model.graph.Algorithms;
import lapr.project.model.graph.matrix.MatrixGraph;
import java.util.*;
/**
 * @author Jorge Lima and Mateus Fernandes
 *
 */
public class ClosestLocal {
    /**
     * Method that returns n closest ports or cities
     *
     * @param mapa Map with the graph
     * @param n Number of closest ports or cities
     * @return returns map with n closest ports or cities
     */
    public Map<PortsGraph, ArrayList<String>> returnClosest(MatrixGraph<PortsGraph, Integer> mapa, int n) {
        ArrayList<LinkedList<PortsGraph>> paths;
        ArrayList<Integer> dists;
        ArrayList<PortsGraph> pgM = mapa.vertices();
        Map<PortsGraph, ArrayList<String>> a = new HashMap<>();
        ArrayList<String> s;

        int sum_weight;
        int count;
        int avg;

        for (PortsGraph pg : pgM) {
            paths = new ArrayList<>();
            dists = new ArrayList<>();
            Algorithms.shortestPaths(mapa, pg, Integer::compare, Integer::sum, 0, paths, dists);

            sum_weight = 0;
            count = 0;
            for (Integer e : dists) {
                sum_weight += e;
                count++;
            }
            avg = sum_weight / count;

            int aux;
            LinkedList<PortsGraph> aux2;
            for (int i = 0; i < dists.size(); i++) {
                for (int j = i + 1; j < dists.size(); j++) {
                    if (dists.get(j).compareTo(dists.get(i).intValue()) == -1) {
                        aux = dists.get(i);
                        dists.set(i, dists.get(j));
                        dists.set(j, aux);
                        aux2 = paths.get(i);
                        paths.set(i, paths.get(j));
                        paths.set(j, aux2);
                    }
                }
            }

            s = new ArrayList<>();
            int cont = 1;
            while(cont < n + 1 && cont < paths.size()){
                if(paths.get(cont).getFirst().getName() == pg.getName() && dists.get(cont) < avg){
                    s.add(paths.get(cont).getLast().getName() + " - Distance: " + dists.get(cont) + " Km");
                }
                cont++;
            }
            a.put(pg, s);
        }
        return a;
    }
}