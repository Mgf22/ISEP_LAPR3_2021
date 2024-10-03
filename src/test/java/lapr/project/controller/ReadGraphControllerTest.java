package lapr.project.controller;

import lapr.project.model.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReadGraphControllerTest {

    @Test
    void read() {
        ReadGraphController a = new ReadGraphController();
        assertFalse(a.read(-1));
        assertTrue(a.read(1));
        App.getInstance().getCompany().resetStores();
    }
}