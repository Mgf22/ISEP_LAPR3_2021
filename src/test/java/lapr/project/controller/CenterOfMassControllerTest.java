package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CenterOfMassControllerTest {
    @Test
    void getCenterOfMass(){
        CenterOfMassController coms = new CenterOfMassController();
        assertEquals(200, coms.getCenterOfMass(750,17000,750,15,200,385));
        assertEquals(25, coms.getCenterOfMass(750,17000,750,25,25,25));
    }

}