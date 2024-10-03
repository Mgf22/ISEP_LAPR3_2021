package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OffloadedContainersControllerTest {

    @Test
    void getListContainers() {
        OffloadedContainersController occ = new OffloadedContainersController();
        assertEquals("Informação indisponível.", occ.getListContainers(211331640));
    }
}