package lapr.project.model.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {
    Edge<String, Integer> a = new Edge<>("a", "a", 1);

    @Test
    void setWeight() {
        assertEquals(1,a.getWeight());
        a.setWeight(2);
        assertEquals(2, a.getWeight());
    }

    @Test
    void testToString() {
        assertEquals("a -> a\nWeight: 1", a.toString());
    }

    @Test
    void testEquals() {
        Edge<String, Integer> b = new Edge<>("a", "b", 1);
        Edge<String, Integer> c = new Edge<>("b", "a", 1);
        Edge<String, Integer> d = new Edge<>("b", "b", 1);
        Edge<String, Integer> e = new Edge<>("a", "a", 2);
        assertEquals(false, a.equals(null));
        assertEquals(false, a.equals(1));
        assertEquals(false, a.equals(b));
        assertEquals(false, a.equals(c));
        assertEquals(false, a.equals(d));
        assertEquals(true, a.equals(e));
        assertEquals(true, a.equals(a));
    }
}