package lapr.project.controller;

import lapr.project.model.PortsGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class US402ControllerTest {
    US402Controller us402 = new US402Controller();
    PortsGraph pg1 = new PortsGraph("Capital", "Lisbon", "", "", 0.0, 0.0);
    PortsGraph pg2 = new PortsGraph("Capital", "Rome", "", "", 0.0, 0.0);
    PortsGraph pg3 = new PortsGraph("Port", "Lysekil Port", "", "", 0.0, 0.0);
    PortsGraph pg4 = new PortsGraph("Port", "Tallinn Port", "", "", 0.0, 0.0);

    @BeforeAll
    static void beforeAll() {
        ReadGraphController rgc = new ReadGraphController();
        rgc.read(3);
    }

    @Test
    void paths() {
        String str = "Type: Capital, Name: Lisbon -> Type: Capital, Name: Madrid -> Type: Capital, Name: Paris -> Type: Capital, Name: Rome";
        assertEquals(str, us402.landPath(pg1, pg2));
        str = "There is no path between the 2 ports by sea.";
        assertEquals(str, us402.maritimePath(pg4, pg3));
        str = "There is no path between the 2 ports by land or sea.";
        assertEquals(str, us402.landMaritimePath(pg1, pg2));
    }
}