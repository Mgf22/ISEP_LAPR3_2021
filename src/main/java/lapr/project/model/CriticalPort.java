package lapr.project.model;

import lapr.project.model.graph.Algorithms;
import lapr.project.model.graph.matrix.MatrixGraph;
import java.util.*;

public class CriticalPort {

    public Map<PortsGraph, Integer> returnCritical(MatrixGraph<PortsGraph, Integer> mapa, int n) {
        ArrayList<LinkedList<PortsGraph>> paths;
        ArrayList<Integer> dists;
        ArrayList<PortsGraph> pgM = mapa.vertices();
        Map<PortsGraph, Integer> a = new HashMap<>();
        int count_ap= 0;

        for (PortsGraph pg : pgM) {
            paths = new ArrayList<>();
            dists = new ArrayList<>();
            Algorithms.shortestPaths(mapa, pg, Integer::compare, Integer::sum, 0, paths, dists);

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

            for (LinkedList<PortsGraph> lk : paths) {
                for (PortsGraph pk : lk) {
                    if (pk.equals(pg) && a.containsKey(pk) && pk.getType().equals("Port")){
                        a.put(pg,count_ap++);
                    } else if (pg.getType().equals("Port")){
                        a.put(pg,count_ap);
                    }
                }
            }
        }
        return a;
    }
}
