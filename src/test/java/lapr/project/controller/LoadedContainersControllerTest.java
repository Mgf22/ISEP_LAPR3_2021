package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoadedContainersControllerTest {

    @Test
    void loadedContainersController() {
        LoadedContainersController lcc = new LoadedContainersController();
        assertEquals("Informação indisponível.", lcc.LoadedContainersController(211331640));
    }
}