package lapr.project.model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void isEmpty() {
        BST<Integer> a = new BST<>();
        assertTrue(a.isEmpty());
        a.insert(1);
        a.insert(1);
        assertFalse(a.isEmpty());
    }

    @Test
    void exists() {
        BST<Integer> a = new BST<>();
        assertFalse(a.exists(1));
        a.insert(1);
        a.insert(-1);
        a.insert(2);
        assertTrue(a.exists(1));
        assertTrue(a.exists(-1));
        assertTrue(a.exists(2));
    }

    @Test
    void remove() {
        BST<Integer> a = new BST<>();
        a.remove(1);
        assertFalse(a.exists(1));

        a.insert(1);
        a.remove(1);
        assertFalse(a.exists(1));

        a.insert(1);
        a.insert(2);
        a.remove(1);
        assertFalse(a.exists(1));

        a = new BST<>();
        a.insert(1);
        a.insert(-1);
        a.remove(1);
        assertFalse(a.exists(1));

        a = new BST<>();
        a.insert(1);
        a.insert(-1);
        a.insert(2);
        a.remove(1);
        assertFalse(a.exists(1));

        a = new BST<>();
        a.insert(1);
        a.insert(-1);
        a.remove(-1);
        assertFalse(a.exists(-1));

        a = new BST<>();
        a.insert(1);
        a.insert(2);
        a.remove(2);
        assertFalse(a.exists(2));
    }

    @Test
    void size() {
        BST<Integer> a = new BST<>();
        assertEquals(0, a.size());
        a.insert(1);
        a.insert(-1);
        a.insert(2);
        assertEquals(3, a.size());
    }

    @Test
    void height() {
        BST<Integer> a = new BST<>();
        assertEquals(-1, a.height());
        a.insert(1);
        assertEquals(0, a.height());
        a.insert(1);
        a.insert(2);
        assertEquals(1, a.height());
        a.insert(1);
        a.insert(-1);
        assertEquals(1, a.height());
    }

    @Test
    void smallestElement() {
        BST<Integer> a = new BST<>();
        assertNull(a.smallestElement());
        a.insert(1);
        assertEquals(new Integer(1), a.smallestElement());
        a.insert(1);
        a.insert(-1);
        assertEquals(new Integer(-1), a.smallestElement());
    }

    @Test
    void biggestElement() {
        BST<Integer> a = new BST<>();
        assertNull(a.biggestElement());
        a.insert(1);
        assertEquals(new Integer(1), a.biggestElement());
        a.insert(1);
        a.insert(2);
        assertEquals(new Integer(2), a.biggestElement());
    }

    @Test
    void inOrder() {
        Integer[] inOrder = {-2,-1,0,1,2};
        List<Integer> lista = new ArrayList<>();
        BST<Integer> a = new BST<>();
        assertEquals(lista, a.inOrder());
        lista = Arrays.asList(inOrder);
        a.insert(1);
        a.insert(-1);
        a.insert(-2);
        a.insert(0);
        a.insert(2);
        assertEquals(lista, a.inOrder());
    }

    @Test
    void preOrder() {
        Integer[] preOrder = {1,-1,-2,0,2};
        List<Integer> lista = new ArrayList<>();
        BST<Integer> a = new BST<>();
        assertEquals(lista, a.preOrder());
        lista = Arrays.asList(preOrder);
        a.insert(1);
        a.insert(-1);
        a.insert(-2);
        a.insert(0);
        a.insert(2);
        assertEquals(lista, a.preOrder());
    }

    @Test
    void posOrder() {
        Integer[] posOrder = {-2,0,-1,2,1};
        List<Integer> lista = new ArrayList<>();
        BST<Integer> a = new BST<>();
        assertEquals(lista, a.posOrder());
        lista = Arrays.asList(posOrder);
        a.insert(1);
        a.insert(-1);
        a.insert(-2);
        a.insert(0);
        a.insert(2);
        assertEquals(lista, a.posOrder());
    }

    @Test
    void nodesByLevel() {
        BST<Integer> a = new BST<>();
        Integer[] arr = {20,15,10,13,8,17,40,50,30,7};
        for(int i :arr)
            a.insert(i);
        Map<Integer,List<Integer>> expResult = new HashMap<>();
        expResult.put(0, Arrays.asList(new Integer[]{20}));
        expResult.put(1, Arrays.asList(new Integer[]{15,40}));
        expResult.put(2, Arrays.asList(new Integer[]{10,17,30,50}));
        expResult.put(3, Arrays.asList(new Integer[]{8,13}));
        expResult.put(4, Arrays.asList(new Integer[]{7}));

        Map<Integer,List<Integer>> result = a.nodesByLevel();

        for(Map.Entry<Integer,List<Integer>> e : result.entrySet())
            assertEquals(expResult.get(e.getKey()), e.getValue());
    }

    @Test
    void testToString() {
        String str = "";
        BST<Integer> a = new BST<>();
        assertEquals(str, a.toString());
        Integer[] arr = {20,15,10,13,8,17,40,50,30,7};
        for(int i :arr)
            a.insert(i);
        str = "|\t|-------50\n|-------40\n|\t|-------30\n20\n|\t|-------17\n|-------15\n|\t|\t|-------13\n|\t|-------10\n|\t|\t|-------8\n|\t|\t|\t|-------7\n";
        assertEquals(str,a.toString());
    }
}