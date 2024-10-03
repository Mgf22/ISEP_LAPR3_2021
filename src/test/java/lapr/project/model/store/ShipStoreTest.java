package lapr.project.model.store;

import lapr.project.model.ShipDynamic;
import lapr.project.model.ShipStatic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipStoreTest {
    @Test
    void getShipStore() {
        ShipStore a = new ShipStore();
        assertNotNull(a.getShipStore());

        ShipStatic ss = new ShipStatic(1,"a","a","a",1,1,1,1,"a");
        ShipDynamic sd = new ShipDynamic(null, 1,1,1,1,1,"a");
        assertNotNull(a.insert(ss,sd));
    }
}