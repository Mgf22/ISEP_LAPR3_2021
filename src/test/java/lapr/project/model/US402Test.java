package lapr.project.model;

import lapr.project.model.graph.matrix.MatrixGraph;
import lapr.project.model.store.GraphStore;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class US402Test {
    @Test
    void US402() {
        US402 us402 = new US402();
        GraphStore a = new GraphStore();
        MatrixGraph<PortsGraph, Integer> g = a.consGraph(3);

        PortsGraph pg1 = new PortsGraph("Capital", "Lisbon", "", "", 0.0, 0.0);
        PortsGraph pg2 = new PortsGraph("Capital", "Rome", "", "", 0.0, 0.0);
        PortsGraph pg3 = new PortsGraph("Capital", "Tallinn", "", "", 0.0, 0.0);
        PortsGraph pg4 = new PortsGraph("Port", "Lysekil Port", "", "", 0.0, 0.0);
        PortsGraph pg5 = new PortsGraph("Port", "Tallinn Port", "", "", 0.0, 0.0);
        PortsGraph pg6 = new PortsGraph("Port", "Helsinki Port", "", "", 0.0, 0.0);
        PortsGraph pg7 = new PortsGraph("Port", "Kotka Port", "", "", 0.0, 0.0);

        //----Land path----
        //vertice de origem e destino a ser uma capital
        List<PortsGraph> l = us402.landPath(g.clone(), pg1, pg2);
        String expected = "[PortsGraph: Type = Capital, Name = Lisbon, PortsGraph: Type = Capital, Name = Madrid, PortsGraph: Type = Capital, Name = Paris, PortsGraph: Type = Capital, Name = Rome]";
        assertEquals(expected, l.toString());

        //vertice de origem ser um porto e destino ser uma capital (garante que passa apenas por caminhos terrestres)
        l.clear();
        l = us402.landPath(g.clone(), pg5, pg3);
        expected = "[PortsGraph: Type = Port, Name = Tallinn Port, PortsGraph: Type = Capital, Name = Tallinn]";
        assertEquals(expected, l.toString());

        //vertice de origem e destino a ser um porto (garante que passa apenas por caminhos terrestres)
        l.clear();
        l = us402.landPath(g.clone(), pg6, pg7);
        expected = "[PortsGraph: Type = Port, Name = Helsinki Port, PortsGraph: Type = Port, Name = Kotka Port]";
        assertEquals(expected, l.toString());


        //----Maritime path----
        l.clear();
        l = us402.maritimePath(g.clone(), pg5, pg4);
        expected = "[PortsGraph: Type = Port, Name = Tallinn Port, PortsGraph: Type = Port, Name = Stockholm Port, PortsGraph: Type = Port, Name = Lysekil Port]";
        assertEquals(expected, l.toString());


        //----Land or Maritime path----
        l.clear();
        l = us402.landMaritimePath(g.clone(), pg1, pg2);
        expected = "[PortsGraph: Type = Capital, Name = Lisbon, PortsGraph: Type = Capital, Name = Madrid, PortsGraph: Type = Capital, Name = Paris, PortsGraph: Type = Capital, Name = Rome]";
        assertEquals(expected, l.toString());
    }
}