package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class US420Test {

    @Test
    void testValues() {
        US420 us420 = new US420();

        assertEquals(7500000, us420.calculateTotalMassPlaced(15000));
        int a = us420.calculateTotalMassPlaced(15000);
        assertEquals(5.66, us420.calculateVesselSink(109000000, 400, 50, a));
        assertEquals(7.4665E7, us420.pressureExertedInWater(109000000, a));
    }
}