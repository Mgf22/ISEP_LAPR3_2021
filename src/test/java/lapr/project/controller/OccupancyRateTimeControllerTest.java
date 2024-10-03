package lapr.project.controller;

import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OccupancyRateTimeControllerTest {

    @Test
    void getOccupancy() {
        OccupancyRateTimeController ortc = new OccupancyRateTimeController();
        try {
            SimpleDateFormat f = new SimpleDateFormat("yy.MM.dd");
            Date data = f.parse("19.12.22");
            assertEquals("0%", Math.round(ortc.getOccupancy(211331640,f.format(data))) + "%");
        } catch (Exception e) {
        }
    }
}