package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class US405ControllerTest {
    @Test
    void getAuditTrail(){
        Us405Controller us405 = new Us405Controller();
        assertEquals("20",us405.getUS405("01/01/2022",255806169));
    }
}
