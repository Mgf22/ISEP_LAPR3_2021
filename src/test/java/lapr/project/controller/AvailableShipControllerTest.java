package lapr.project.controller;

import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AvailableShipControllerTest {

    @Test
    void getAvailableShip() {
        AvailableShipController ass = new AvailableShipController();
        try {
            SimpleDateFormat f = new SimpleDateFormat("yy.MM.dd");
            Date data = f.parse("21.12.13");
            assertEquals("", ass.getAvailableShip(f.format(data)));
        } catch (Exception e) {
        }
    }
}