package lapr.project.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManifestTransportControllerTest {

    @Test
    void getManifestTransport() {
        ManifestTransportController mtc = new ManifestTransportController();
        assertEquals("Containers: 0 Average per manifest: 0", mtc.getManifestTransport(2, 2021));
    }
}