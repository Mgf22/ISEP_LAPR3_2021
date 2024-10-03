package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PairPortsTest {
    PairPorts a = new PairPorts("a","a","a", "a", 1);

    @Test
    void getPort1() {
        assertEquals("a", a.getPort1());
    }

    @Test
    void getPort2() {
        assertEquals("a", a.getPort2());
    }

    @Test
    void getCountry1() {
        assertEquals("a", a.getCountry1());
    }

    @Test
    void getCountry2() {
        assertEquals("a", a.getCountry2());
    }

    @Test
    void getDistance() {
        assertEquals(1, a.getDistance());
    }

    @Test
    void compareTo() {
        PairPorts b = new PairPorts("a","a","a", "a", 2);
        assertEquals(-1, a.compareTo(b));
        assertEquals(1, b.compareTo(a));
        assertEquals(0, a.compareTo(a));
    }
}