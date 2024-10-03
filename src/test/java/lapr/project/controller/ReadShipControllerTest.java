package lapr.project.controller;

import lapr.project.model.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReadShipControllerTest {
    @Test
    void read() {
        ReadShipController a = new ReadShipController();

        String caminho = "src/main/java/lapr/project/csv/sships.csv";
        assertTrue(a.read(caminho));

        caminho = "src/main/java/lapr/project/csv/bships.csv";
        assertTrue(a.read(caminho));

        caminho = "";
        assertFalse(a.read(caminho));
        App.getInstance().getCompany().resetStores();
    }
}