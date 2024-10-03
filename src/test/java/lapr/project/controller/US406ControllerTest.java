package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class US406ControllerTest {

    @Test
    void getUS406() {
        US406Controller us406 = new US406Controller();
        assertEquals("Origin: Salvador Port, Date: 18/01/2022 -> Destination: Rio Grande Port, Date: 18/01/2022\n", us406.getUS406(70));
    }
}