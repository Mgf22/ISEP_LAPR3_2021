package lapr.project.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class US414_US415Test {

    @Test
    void energy() {
        US414_US415 us414 = new US414_US415();
        Map<Double, Double> m = new HashMap<>();
        m.put(20.1, 1.2);
        m.put(14.2, 1.5);
        m.put(-5.1, 2.3);
        m.put(25.2, 4.9);
        assertEquals(47597.86, us414.getEnergy7C(10, m));
        assertEquals(87782.66, us414.getEnergy5C(10, m));
        assertEquals(10121.15, us414.getEnergyExposedContainers7C(5,3,4,m));
        assertEquals(18666.01, us414.getEnergyExposedContainers5C( 5,3,4,m));
        assertEquals(3, us414.getNumberOfPowerEquipmentNecessary(1.5, 300));
    }
}