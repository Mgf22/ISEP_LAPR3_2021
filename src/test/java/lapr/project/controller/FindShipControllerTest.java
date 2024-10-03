package lapr.project.controller;

import lapr.project.model.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FindShipControllerTest {
    @Test
    void testGetShips() {
        FindShipController a = new FindShipController();
        ReadShipController f = new ReadShipController();
        String caminho = "src/main/java/lapr/project/csv/sships.csv";
        f.read(caminho);
        caminho = "src/main/java/lapr/project/csv/bships.csv";
        f.read(caminho);

        assertEquals("Ship_static{ MMSI = 211331640, Vessel Name = SEOUL EXPRESS, IMO = IMO9193305, Call Sign = DHBN, Vessel Type = 70, Length = 70, Width = 32, Draft = 13.6, Cargo = 79}",a.getShips("211331640"));
        assertEquals("Ship does not exist", a.getShips("999999999"));
        assertEquals("Ship_static{ MMSI = 366710820, Vessel Name = WSF SEALTH, IMO = IMO7808152, Call Sign = WAK7089, Vessel Type = 60, Length = 60, Width = 23, Draft = 5.2, Cargo = NA}", a.getShips("IMO7808152"));
        assertEquals("Ship_static{ MMSI = 311056900, Vessel Name = CSL TECUMSEH, IMO = IMO9600994, Call Sign = C6ZJ6, Vessel Type = 70, Length = 70, Width = 32, Draft = 13.5, Cargo = NA}", a.getShips("C6ZJ6"));
        assertEquals("Ship does not exist", a.getShips("C6"));
        App.getInstance().getCompany().resetStores();
    }
}