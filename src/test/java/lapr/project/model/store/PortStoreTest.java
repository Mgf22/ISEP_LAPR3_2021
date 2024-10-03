package lapr.project.model.store;

import lapr.project.model.Ports;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PortStoreTest {
    PortStore ps = new PortStore();
    @Test
    void getPortStore() {
        assertNotNull(ps.getPortStore());
    }

    @Test
    void balanceTree() {
        Ports p1 = new Ports(1, "a", 0,0,"a", "a");
        Ports p2 = new Ports(2, "b", 10,10,"b", "b");
        Ports p3 = new Ports(3, "c", 0,10,"c", "c");
        Ports p4 = new Ports(4, "d", 10,0,"d", "d");
        Ports p5 = new Ports(5, "e",20,20, "e", "e");

        ps.insert(p1, 0, 0);
        ps.insert(p2, 10, 10);
        ps.insert(p3, 0, 10);
        ps.insert(p4, 10, 0);
        ps.insert(p5, 20, 20);

        List<Ports> s = new ArrayList<>();
        s.add(p1);
        s.add(p4);
        s.add(p3);
        s.add(p2);
        s.add(p5);

        assertEquals(s, ps.balanceTree().inOrder());
    }
}