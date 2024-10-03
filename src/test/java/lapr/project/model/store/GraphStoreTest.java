package lapr.project.model.store;

import lapr.project.controller.ClosestLocalController;
import lapr.project.model.App;
import lapr.project.model.PortsGraph;
import lapr.project.model.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphStoreTest {
    static MatrixGraph<PortsGraph, Integer> graph = new MatrixGraph<>(false);
    static GraphStore gs = new GraphStore();
    @BeforeAll
    static void beforeAll(){
        graph = gs.consGraph(10);
    }

    @Test
    void testGetGraph() {
        assertNotNull(graph);
        assertEquals(145, graph.numVertices());
        assertEquals(1380, graph.numEdges());
        assertEquals(null, gs.consGraph(-1));

        //Capitals test
        Collection<PortsGraph> av1 = graph.adjVertices(new PortsGraph("Capital", "Lisbon", "", "", 0.0, 0.0));
        List<PortsGraph> a = new ArrayList<>(av1);

        assertEquals(new PortsGraph("Capital", "Madrid", "", "", 0.0, 0.0), a.get(a.indexOf(new PortsGraph("Capital", "Madrid", "", "", 0.0, 0.0))));
        assertEquals(new PortsGraph("Port", "Setubal Port", "", "", 0.0, 0.0), a.get(a.indexOf(new PortsGraph("Port", "Setubal Port", "", "", 0.0, 0.0))));
    }

    @Test
    void testDistance() {
        assertEquals(152, gs.distance(20.0, 19.0, 21.0, 20.0));
        assertEquals(471, gs.distance(-2.0, 1.0, -1.0, 2.0));
        assertEquals(471, gs.distance(2.0, -1.0, 1.0, -2.0));
        assertEquals(157, gs.distance(-2.0, -1.0, -1.0, -2.0));
    }
}