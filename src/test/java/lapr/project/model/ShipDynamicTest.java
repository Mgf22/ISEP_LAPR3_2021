package lapr.project.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ShipDynamicTest {
    static Date date1,date2;
    static ShipDynamic a,b,c;
    static @BeforeAll
    void p(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date1 = sdf.parse("01/02/1969");
            date2 = sdf.parse("01/02/1970");
        } catch (Exception e) {
            //empty;
        }
        a = new ShipDynamic(date1,1,1,1,1,1,"abc");
        b = new ShipDynamic(date2,1,1,1,1,1,"abc");
        c = new ShipDynamic(date1,1,1,1,1,1,"abc");
    }

    @Test
    void getBaseDateTime() {
        Date expected = date1;
        Date result = a.getBaseDateTime();
        assertEquals(expected, result);
    }

    @Test
    void getLAT() {
        float expected = 1;
        float result = a.getLAT();
        assertEquals(expected, result);
    }

    @Test
    void getLON() {
        float expected = 1;
        float result = a.getLON();
        assertEquals(expected, result);
    }

    @Test
    void compareTo() {
        int expected = -1;
        assertEquals(expected, a.compareTo(b));
        expected = 1;
        assertEquals(expected, b.compareTo(a));
        expected = 0;
        assertEquals(expected, a.compareTo(c));
    }
}