package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateEnergyControllerTest {
    @Test
    void getEnergy(){
        CalculateEnergyController ces = new CalculateEnergyController();
        assertEquals(94352, Math.round(ces.getEnergy(0.15,1.09,3.85E-5,20,7,9000)));
        assertEquals(142402, Math.round(ces.getEnergy(0.15,1.43,3.85E-5,20,-5,9000)));
    }
}