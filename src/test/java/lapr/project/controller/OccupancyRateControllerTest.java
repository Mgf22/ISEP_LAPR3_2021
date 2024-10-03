package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OccupancyRateControllerTest {

    @Test
    void getOccupancy() {
        OccupancyRateController orc = new OccupancyRateController();
        assertEquals("0%", Math.round(orc.getOccupancy(211331640, 2)) + "%");
    }
}