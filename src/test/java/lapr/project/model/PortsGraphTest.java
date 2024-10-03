package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortsGraphTest {
    PortsGraph a = new PortsGraph("a", "a", "a", "a", 1,1);

    @Test
    void getType() {
        assertEquals("a", a.getType());
    }

    @Test
    void getName() {
        assertEquals("a", a.getName());
    }

    @Test
    void getContinent() {
        assertEquals("a", a.getContinent());
    }

    @Test
    void getLon() {
        assertEquals(1, a.getLon());
    }

    @Test
    void getLat() {
        assertEquals(1, a.getLat());
    }

    @Test
    void setColor() {
        assertEquals(-1, a.getColor());
        a.setColor(1);
        assertEquals(1, a.getColor());
    }

    @Test
    void getCountry(){
        assertEquals("a", a.getCountry());
    }

    @Test
    void testEquals() {
        PortsGraph b = new PortsGraph("b", "a", "a","a", 1,1);
        PortsGraph c = new PortsGraph("a", "b", "a","a", 1,1);
        PortsGraph d = new PortsGraph("b", "b", "a","a", 1,1);
        assertEquals(false, a.equals(b));
        assertEquals(false, a.equals(c));
        assertEquals(false, a.equals(d));
        assertEquals(true, a.equals(a));
        assertEquals(false, a.equals(1));
    }

    @Test
    void isColored() {
        assertFalse(a.isColored());
        a.setColor(0);
        assertTrue(a.isColored());
    }

    @Test
    void testToString() {
        assertEquals("PortsGraph: Type = a, Name = a",a.toString());
    }
}