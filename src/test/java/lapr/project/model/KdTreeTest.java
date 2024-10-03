package lapr.project.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class KdTreeTest {
    Ports p1 = new Ports(1, "a", 0,0,"a", "a");
    Ports p2 = new Ports(2, "b", 10,10,"b", "b");
    Ports p3 = new Ports(3, "c", 0,10,"c", "c");
    Ports p4 = new Ports(4, "d", 10,0,"d", "d");
    Ports p5 = new Ports(5, "e",20,20, "e", "e");
    Ports p6 = new Ports(6, "f",-5,-5, "e", "e");
    Ports p7 = new Ports(7, "g",-6,-6, "e", "e");
    KdTree<Object> k = new KdTree<>();

    @Test
    void isEmpty() {
        assertTrue(k.isEmpty());
        k.insert(p1, 0, 0);
        assertFalse(k.isEmpty());
    }

    @Test
    void insert() {
        k.insert(p1, 0, 0);
        Object node = k.findNearestNeighbour(0,0);
        assertEquals(p1, node);

        k.insert(p2, 10, 10);
        node = k.findNearestNeighbour(10,10);
        assertEquals(p2, node);

        k.insert(p3, 0, 10);
        node = k.findNearestNeighbour(0,10);
        assertEquals(p3, node);

        k.insert(p4, 10, 0);
        node = k.findNearestNeighbour(10,0);
        assertEquals(p4, node);

        k.insert(p5, 20, 20);
        node = k.findNearestNeighbour(20,20);
        assertEquals(p5, node);

        k.insert(p6, -5, -5);
        node = k.findNearestNeighbour(-4,-4);
        assertEquals(p6, node);

        k.insert(p7, -6, -6);
        node = k.findNearestNeighbour(-7,-7);
        assertEquals(p7, node);
    }

    @Test
    void size() {
        k.insert(p1, 0, 0);
        k.insert(p2, 10, 10);
        k.insert(p3, 0, 10);
        k.insert(p4, 10, 0);
        k.insert(p5, 20, 20);

        assertEquals(5, k.size());
    }

    @Test
    void inOrder() {
        List<Ports> s = new ArrayList<>();
        assertEquals(s, k.inOrder());
        k.insert(p1, 0, 0);
        k.insert(p2, 10, 10);
        k.insert(p3, 0, 10);
        k.insert(p4, 10, 0);
        k.insert(p5, 20, 20);
        s.add(p1);
        s.add(p4);
        s.add(p2);
        s.add(p3);
        s.add(p5);
        assertEquals(s, k.inOrder());
    }

    @Test
    void balanceTree() {
        List<Ports> s = new ArrayList<>();
        assertEquals(s, k.inOrder());
        k.insert(p1, 0, 0);
        k.insert(p2, 10, 10);
        k.insert(p3, 0, 10);
        k.insert(p4, 10, 0);
        k.insert(p5, 20, 20);
        k.balanceTree();
        s.add(p1);
        s.add(p4);
        s.add(p3);
        s.add(p2);
        s.add(p5);
        assertEquals(s, k.inOrder());
    }
}