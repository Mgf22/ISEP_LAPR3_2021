package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvalidContainerControllerTest {
    @Test
    void getContainer() {
        InvalidContainerController icos = new InvalidContainerController();
        assertEquals("(11 - container is not leased by client) Id_Container: NHJK3127847", icos.getInvalidContainer("NHJK3127847",2));
        assertEquals("(10 - invalid container id) Id_Container: POPCJ987847", icos.getInvalidContainer("POPCJ987847",2));
    }
}