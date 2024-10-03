package lapr.project.controller;

import lapr.project.model.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReadPortControllerTest {
    @Test
    void readPort() {
        ReadPortController a = new ReadPortController();

        String caminho = "src/main/java/lapr/project/csv/bports.csv";
        assertTrue(a.readPort(caminho));

        caminho = "src/main/java/lapr/project/csv/sports.csv";
        assertTrue(a.readPort(caminho));

        caminho = "";
        assertFalse(a.readPort(caminho));
        App.getInstance().getCompany().resetStores();
    }
}