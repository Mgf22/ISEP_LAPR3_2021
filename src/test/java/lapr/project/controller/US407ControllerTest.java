package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class US407ControllerTest {

    @Test
    void getUS407() {
        US407Controller us407 = new US407Controller();
        assertEquals("Facility: Vancouver Port, Truck: 65-87-RE, Containers: 1, Type Manifest: Unload, Date: 02/01/2022\n",us407.getUS407("01/01/2022"));
    }
}