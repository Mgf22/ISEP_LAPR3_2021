package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipStaticTest {
    ShipStatic a = new ShipStatic(1,"a", "a", "a", 1,1,1, 1, "a");

    @Test
    void getMmsi() {
        int expected = 1;
        int result = a.getMmsi();
        assertEquals(expected, result);
    }

    @Test
    void getImo() {
        String expected = "a";
        String result = a.getImo();
        assertEquals(expected, result);
    }

    @Test
    void getCallSign() {
        String expected = "a";
        String result = a.getCallSign();
        assertEquals(expected, result);
    }

    @Test
    void testToString() {
        String expected = "Ship_static{ MMSI = 1, Vessel Name = a, IMO = a, Call Sign = a, Vessel Type = 1, Length = 1, Width = 1, Draft = 1.0, Cargo = a}";
        String result = a.toString();
        assertEquals(expected,result);
    }
}