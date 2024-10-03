package lapr.project.model;

import lapr.project.model.graph.Algorithms;
import lapr.project.model.graph.matrix.MatrixGraph;
import java.util.*;
/**
 * @author Jorge Lima
 */
public class US402 {
    /**
     * Method that calculates best path between 2 ports by land
     *
     * @param graph Graph with all ports
     * @param start Starting port
     * @param end Destination
     * @return returns shortest path by land
     */
    public LinkedList<PortsGraph> landPath(MatrixGraph<PortsGraph, Integer> graph, PortsGraph start, PortsGraph end) {
        for (PortsGraph pg : graph.vertices()) {
            if (pg.getType().equals("Port") && !(pg.equals(start) || pg.equals(end))) {
                graph.removeVertex(pg);
            }
        }

        LinkedList<PortsGraph> shortestPath = new LinkedList<>();
        Algorithms.shortestPath(graph, start, end, Integer::compare, Integer::sum, 0, shortestPath);
        return shortestPath;
    }
    /**
     * Method that calculates best path between 2 ports by sea
     *
     * @param graph Graph with all ports
     * @param start Starting port
     * @param end Destination
     * @return returns shortest path by sea
     */
    public LinkedList<PortsGraph> maritimePath(MatrixGraph<PortsGraph, Integer> graph, PortsGraph start, PortsGraph end) {
        for (PortsGraph pg : graph.vertices()) {
            if (pg.getType().equals("Capital")) {
                graph.removeVertex(pg);
            }
        }
        LinkedList<PortsGraph> shortestPath = new LinkedList<>();
        Algorithms.shortestPath(graph, start, end, Integer::compare, Integer::sum, 0, shortestPath);
        return shortestPath;
    }
    /**
     * Method that calculates best path between 2 ports
     *
     * @param graph Graph with all ports
     * @param start Starting port
     * @param end Destination
     * @return returns shortest path
     */
    public LinkedList<PortsGraph> landMaritimePath(MatrixGraph<PortsGraph, Integer> graph, PortsGraph start, PortsGraph end) {
        LinkedList<PortsGraph> shortestPath = new LinkedList<>();
        Algorithms.shortestPath(graph, start, end, Integer::compare, Integer::sum, 0, shortestPath);
        return shortestPath;
    }
}