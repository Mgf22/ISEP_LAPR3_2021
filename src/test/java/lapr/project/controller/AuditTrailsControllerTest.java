package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuditTrailsControllerTest {
    @Test
    void getAuditTrail(){
        AuditTrailsController ats = new AuditTrailsController();
        assertEquals("\n Id of operation made on the container (1-INSERT) (2-UPDATE) (3-DELETE): 1\n" +
                " Id of operation made on the container (1-INSERT) (2-UPDATE) (3-DELETE): 2\n" +
                " Id of operation made on the container (1-INSERT) (2-UPDATE) (3-DELETE): 1",ats.getAuditTrails(6,"BIYT9897847"));
    }
}
