package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FindContainerControllerTest {
    @Test
    void getContainer() {
        FindContainerController fcs = new FindContainerController();
        assertEquals("Informação inválida.", fcs.getContainer("POLK3597847"));
        assertEquals("Port, Barcelona Port", fcs.getContainer("BICJ5697847"));
    }
}