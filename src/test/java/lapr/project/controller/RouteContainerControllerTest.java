package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RouteContainerControllerTest {
    @Test
    void getRouteContainer() {
        RouteContainerController rcc = new RouteContainerController();
        assertEquals("Invalid identifier or container not leased", rcc.getRouteContainer(1,"POPCJ987847"));
    }
}