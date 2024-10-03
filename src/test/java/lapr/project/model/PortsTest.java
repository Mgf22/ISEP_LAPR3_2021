package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PortsTest {

    @Test
    void testToString() {
        Ports a = new Ports(1,"a",1,1,"a","a");
        String str = "Port: IdPort = 1, Name = a, Latitude = 1.0, Longitude = 1.0, Continent = a, Country = a";
        assertEquals(str, a.toString());
    }
}