package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PairsShipsTest {
    PairsShips a = new PairsShips(1, 1, 1, 1, 1, 1,1, 1);
    PairsShips b = new PairsShips(1, 1, 1, 1, 1, 1,1, 2);
    PairsShips c = new PairsShips(1, 1, 1, 1, 1, 1,1, 1);

    @Test
    void getMmsi1() {
        int expected = 1;
        int result = a.getMmsi1();
        assertEquals(expected, result);
    }

    @Test
    void getMmsi2() {
        int expected = 1;
        int result = a.getMmsi2();
        assertEquals(expected, result);
    }

    @Test
    void getDist1() {
        double expected = 1;
        double result = a.getDist1();
        assertEquals(expected, result);
    }

    @Test
    void getDist2() {
        double expected = 1;
        double result = a.getDist2();
        assertEquals(expected, result);
    }

    @Test
    void getMoves1() {
        int expected = 1;
        int result = a.getMoves1();
        assertEquals(expected, result);
    }

    @Test
    void getTravelDist1() {
        double expected = 1;
        double result = a.getTravelDist1();
        assertEquals(expected, result);
    }

    @Test
    void getMoves2() {
        int expected = 1;
        int result = a.getMoves2();
        assertEquals(expected, result);
    }

    @Test
    void getTravelDist2() {
        double expected = 1;
        double result = a.getTravelDist2();
        assertEquals(expected, result);
    }

    @Test
    void compareTo() {
        double expected = 1;
        assertEquals(expected, a.compareTo(b));
        expected = -1;
        assertEquals(expected, b.compareTo(a));
        expected = 0;
        assertEquals(expected, a.compareTo(c));
    }

    @Test
    void testToString() {
        String str = "PairsShips{MMSI1 = 1, MMSI2 = 1, distOrig = 1.0, distDest = 1.0, moves1 = 1, travelDist1 = 1.0, moves2 = 1, travelDist2 = 1.0}";
        assertEquals(str, a.toString());
    }
}