package lapr.project.controller;

import lapr.project.model.BST;
import lapr.project.model.ShipDynamic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PairShipControllerTest {
    PairShipController a = new PairShipController();
    BST<ShipDynamic> b = new BST<>();

    static Date date1,date2;
    static ShipDynamic c,d;
    static @BeforeAll
    void p(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = sdf.parse("01/02/1969");
            date2 = sdf.parse("01/02/1970");
        } catch (Exception e) {
            //empty;
        }
        c = new ShipDynamic(date1,1,1,1,1,1,"abc");
        d = new ShipDynamic(date2,1,1,1,1,1,"abc");
    }

    @Test
    void filterList() {
    }

    @Test
    void distance() {
        assertEquals(152809.01, a.distance(20.0, 19.0, 21.0, 20.0));
        assertEquals(471725.29, a.distance(-2.0, 1.0, -1.0, 2.0));
        assertEquals(471725.29, a.distance(2.0, -1.0, 1.0, -2.0));
        assertEquals(157225.8, a.distance(-2.0, -1.0, -1.0, -2.0));
    }

    @Test
    void distTotal() {/*
        b.insert(c);
        b.insert(d);
        assertEquals(0, a.distTotal(b));
        */
    }
}