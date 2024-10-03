package lapr.project.model;

import lapr.project.controller.PaintGraphController;
import lapr.project.model.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ColorGraphTest {
    static MatrixGraph<PortsGraph, Integer> graph = new MatrixGraph<>(false);

    @BeforeAll
    static void beforeAll() {
        graph.addEdge(new PortsGraph("Capital", "Porto", "","Portugal", 0.0, 0.0), new PortsGraph("Capital", "Madrid", "","Espanha",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Madrid", "","Espanha", 0.0, 0.0), new PortsGraph("Capital", "Zurique","", "Suíça",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Zurique","", "Suíça", 0.0, 0.0), new PortsGraph("Capital", "Berlim", "","Alemanha",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Zurique","", "Suíça", 0.0, 0.0), new PortsGraph("Capital", "Bruxelas", "","Belgica",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Zurique","", "Suíça", 0.0, 0.0), new PortsGraph("Capital", "Luxemburgo", "","Luxemburgo",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Zurique","", "Suíça", 0.0, 0.0), new PortsGraph("Capital", "Roma","", "Italia",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Berlim", "","Alemanha", 0.0, 0.0), new PortsGraph("Capital", "Bruxelas", "", "Belgica",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Génova","", "Italia", 0.0, 0.0), new PortsGraph("Capital", "Leixões", "","Portugal",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Berlim", "","Alemanha", 0.0, 0.0), new PortsGraph("Capital", "Dublin", "", "Irlanda",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Berlim", "","Alemanha", 0.0, 0.0), new PortsGraph("Capital", "Varsovia", "", "Polonia",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Bruxelas", "","Belgica", 0.0, 0.0), new PortsGraph("Capital", "Luxemburgo", "","Luxemburgo",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Capital", "Dublin", "", "Irlanda", 0.0, 0.0), new PortsGraph("Capital", "Roma","", "Italia",  0.0, 0.0), 0);

        graph.addEdge(new PortsGraph("Port", "Leixões", "","Portugal", 0.0, 0.0), new PortsGraph("Port", "Valencia", "","Espanha",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Port", "Leixões", "","Portugal", 0.0, 0.0), new PortsGraph("Port", "Roma","", "Italia",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Port", "Porto", "","Portugal", 0.0, 0.0), new PortsGraph("Port", "Leixões", "","Portugal",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Port", "Porto", "","Portugal", 0.0, 0.0), new PortsGraph("Port", "Funchal", "","Portugal",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Port", "Valencia", "","Espanha", 0.0, 0.0), new PortsGraph("Port", "Porto", "","Portugal",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Port", "Génova","", "Italia", 0.0, 0.0), new PortsGraph("Port", "Valencia", "","Espanha",  0.0, 0.0), 0);
        graph.addEdge(new PortsGraph("Port", "Berlim", "","Alemanha", 0.0, 0.0), new PortsGraph("Port", "Luxemburgo", "","Luxemburgo",  0.0, 0.0), 0);
    }

    @Test
    void colorGraph() {
        ColorGraph cg = new ColorGraph();
        ArrayList<PortsGraph> pgA = graph.vertices();
        cg.paintGraph(graph);

        String atual = "";

        for (PortsGraph pg : pgA) {
            if (pg.getType().equals("Capital")) {
                atual += pg.getName() + " " + pg.getColor() + "\n";
            }
        }

        String str = "Porto 0\nMadrid 1\nZurique 0\nBerlim 1\nBruxelas 2\nLuxemburgo 1\nRoma 1\nGénova 1\nLeixões 0\nDublin 0\nVarsovia 0\n";
        assertEquals(str, atual);

        for (PortsGraph pg : pgA) {
            atual += pg.getName() + " " + pg.getColor() + "\n";
        }

        str = "Porto 0\nMadrid 1\nZurique 0\nBerlim 1\nBruxelas 2\nLuxemburgo 1\nRoma 1\nGénova 1\nLeixões 0\nDublin 0\n" +
                "Varsovia 0\nPorto 0\nMadrid 1\nZurique 0\nBerlim 1\nBruxelas 2\nLuxemburgo 1\nRoma 1\nGénova 1\nLeixões 0\n" +
                "Dublin 0\nVarsovia 0\nLeixões 0\nValencia 1\nRoma 1\nPorto 0\nFunchal 0\nGénova 1\nBerlim 1\nLuxemburgo 1\n";

        assertEquals(str, atual);
    }

    @Test
    void controllerPaintGraph(){
        PaintGraphController b = new PaintGraphController();
        assertTrue(b.paint());
    }
}