package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalEnergyControllerTest {
    @Test
        void getContainerThermalResistance() {
            US413Controller us413 = new US413Controller();
            assertEquals("Para alimentar os contentores refrigerados a 7ºC são necessários: 138336.0W\nPara alimentar os contentores refrigerados a -5ºC são necessários: 158200.0W\nTotal de energia necessária para alimentar os contentores refrigerados: 296536.0W", us413.getTotalEnergy(13200, 10000));
        }
    }

