package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class US419ControllerTest {
    @Test
    void getContainerThermalResistance(){
        US419Controller us419 = new US419Controller();
        assertEquals("Contentor: 1\n" +
                "Área do contentor: 67.21450000000002 metros quadrados\n" +
                "Volume do contentor: 33.178945000000006 metros cúbicos\n" +
                "Centro de massa: \n" +
                "X: 2.95m\n" +
                "Y: 1.175m\n" +
                "Z: 1.1965m.", us419.getContainersInfo(1));
    }
}
