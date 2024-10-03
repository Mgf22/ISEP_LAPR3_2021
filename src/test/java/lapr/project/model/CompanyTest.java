package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company a = new Company();

    @Test
    void getShipStore() {
        assertNotNull(a.getShipStore());
    }

    @Test
    void getContainersStore() {
        assertNotNull(a.getContainersStore());
    }

    @Test
    void getOccupancyRateStore() {
        assertNotNull(a.getOccupancyRateStore());
    }

    @Test
    void getAvailableShipStore() {
        assertNotNull(a.getAvailableShipStore());
    }

    @Test
    void getLoadedContainers() {
        assertNotNull(a.getLoadedContainers());
    }

    @Test
    void getOccupancyRateTimeStore() {
        assertNotNull(a.getOccupancyRateTimeStore());
    }

    @Test
    void getContainer() { assertNotNull(a.getContainer()); }

    @Test
    void getManifestTransport() { assertNotNull(a.getManifestTransport()); }

    @Test
    void getGraphStore() { assertNotNull(a.getGraphStore()); }

    @Test
    void getInsertFrontierStore() { assertNotNull(a.getInsertFrontierStore());}

    @Test
    void getInsertCountryStore() {assertNotNull(a.getInsertCountryStore());}

    @Test
    void getInsertSeaDistStore() {assertNotNull(a.getInsertSeaDistStore());}

    @Test
    void getInsertFacilityStore() {assertNotNull(a.getInsertFacilityStore());}

    @Test
    void getInsertCityStore() {assertNotNull(a.getInsertCityStore());}

    @Test
    void getOccupancyWarehouseStore() {assertNotNull(a.getOccupancyWarehouseStore());}
}