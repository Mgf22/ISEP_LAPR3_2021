package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdleShipsControllerTest {
    @Test
    void getIdleShip(){
        IdleShipsController iss = new IdleShipsController();
        assertEquals("Days the ship 636092932 has been idle in the year 2022: 0",iss.getIdleShip(2022,"636092932"));
    }
}