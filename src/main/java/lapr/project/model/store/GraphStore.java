package lapr.project.model.store;

import lapr.project.model.graph.matrix.MatrixGraph;
import lapr.project.data.ReadInfoGraph;
import lapr.project.model.PairPorts;
import lapr.project.model.PortsGraph;
import java.util.*;
/**
 * @author Jorge Lima
 */
public class GraphStore {
    private MatrixGraph<PortsGraph, Integer> graph = new MatrixGraph<>(false);

    public GraphStore(){
        //Empty
    }
    /**
     * Method that gets the graph with the information needed
     *
     * @return returns graph with information needed
     */
    public MatrixGraph<PortsGraph, Integer> getGraphStore(){return graph;}
    /**
     * Method that constructs and gets the graph with the information needed
     *
     * @param n max number of connections bewtween ports
     * @return returns graph with information needed
     */
    public MatrixGraph<PortsGraph, Integer> consGraph(int n){
        if(n < 0){ return null; }

        ReadInfoGraph rig = new ReadInfoGraph();
        insertCapitals(rig.getCapitalPorts());
        insertFrontiers(rig.getFrontiers());
        insertPorts(rig.getSeaDist(), n);

        return graph;
    }
    /**
     * Method that inserts the capitals
     *
     * @param capitalPorts map with all capitals and ports
     */
    private void insertCapitals(Map<PortsGraph, ArrayList<PortsGraph>> capitalPorts){
        int mDist;
        int dist;
        PortsGraph pg = new PortsGraph("","","","",0.0,0.0);

        for(PortsGraph i : capitalPorts.keySet()){
            graph.addVertex(i);
            mDist = Integer.MAX_VALUE;

            if(capitalPorts.get(i).size() > 0){
                for(PortsGraph j : capitalPorts.get(i)){
                    graph.addVertex(j);
                    dist = distance(i.getLat(), j.getLat(), i.getLon(),j.getLon());
                    if(dist < mDist){
                        mDist = dist;
                        pg = new PortsGraph(j.getType(), j.getName(), j.getContinent(), j.getCountry(), j.getLon(), j.getLat());
                    }
                }
                graph.addEdge(i, pg, mDist);
            }
        }
    }
    /**
     * Method that inserts the frontiers
     *
     * @param frontiers map with the countries borders
     */
    private void insertFrontiers(Map<PortsGraph, ArrayList<PortsGraph>> frontiers){
        for(PortsGraph i : frontiers.keySet()){
            for(PortsGraph j : frontiers.get(i)){
                graph.addEdge(i, j, distance(i.getLat(), j.getLat(), i.getLon(), j.getLon()));
            }
        }
    }
    /**
     * Method that inserts the pairs of ports
     *
     * @param n max number of connections
     * @param portsList pairs of ports to be inserted
     */
    private void insertPorts(List<PairPorts> portsList, int n){
        Collections.sort(portsList);
        Map<String, Integer> contN = new HashMap<>();

        for(PairPorts i : portsList){
            if(!contN.containsKey(i.getPort1())){ contN.put(i.getPort1(),0); }
            if(!contN.containsKey(i.getPort2())){ contN.put(i.getPort2(),0); }

            if(i.getCountry1().equals(i.getCountry2())){
                graph.addEdge(new PortsGraph("Port", i.getPort1(), "", i.getCountry1(),0.0, 0.0), new PortsGraph("Port", i.getPort2(), i.getCountry1(),"", 0.0, 0.0), 0);
            }else if(contN.get(i.getPort1()) < n || contN.get(i.getPort2()) < n){
                graph.addEdge(new PortsGraph("Port", i.getPort1(), "",i.getCountry1(), 0.0, 0.0), new PortsGraph("Port", i.getPort2(), i.getCountry2(),"", 0.0, 0.0), i.getDistance());
                contN.put(i.getPort1(), contN.get(i.getPort1()) + 1);
                contN.put(i.getPort2(), contN.get(i.getPort2()) + 1);
            }
        }
    }

    /**
     * Method that calculates the distance between 2 points
     *
     * @param lat1 Latitude of the first point
     * @param lat2 Latitude of the second point
     * @param long1 Longitude of the first point
     * @param long2 Longitude of the second point
     */
    public int distance(double lat1, double lat2, double long1, double long2){
        double a;
        double c;
        double r = 6371000;
        double difLong;
        double difLat;

        difLat = (lat2-lat1) * (3.1416/180);
        difLong = (long2-long1) * (3.1416/180);
        lat1 = lat1 * (3.1416/180);
        lat2 = lat2 * (3.1416/180);

        a = Math.sin(difLat/2) * Math.sin(difLat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(difLong/2) * Math.sin(difLong/2);
        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return ((int) (r * c / 1000)); // in km
    }
}
