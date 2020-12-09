package week07d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void createWithConstructor() {
        Date date1 = new Date(1972, 12, 30);
        Assertions.assertEquals(1972, date1.getYear());
        Assertions.assertEquals(12, date1.getMonth());
        Assertions.assertEquals(30, date1.getDay());
    }

    @Test
    public void createWithOf() {
        Date date2 = Date.of(1972, 12, 30);
        Assertions.assertEquals(1972, date2.getYear());
        Assertions.assertEquals(12, date2.getMonth());
        Assertions.assertEquals(30, date2.getDay());
    }

    @Test
    public void createWithWithYear() {
        Date date3 = new Date(1972, 12, 30);
        date3 = date3.withYear(1982);
        Assertions.assertEquals(1982, date3.getYear());
        Assertions.assertEquals(12, date3.getMonth());
        Assertions.assertEquals(30, date3.getDay());
    }

    @Test
    public void createWithWithMonth() {
        Date date4 = new Date(1972, 12, 30);
        date4 = date4.withMonth(10);
        Assertions.assertEquals(1972, date4.getYear());
        Assertions.assertEquals(10, date4.getMonth());
        Assertions.assertEquals(30, date4.getDay());
    }

    @Test
    public void createWithWithDay() {
        Date date5 = new Date(1972, 12, 30);
        date5 = date5.withDay(29);
        Assertions.assertEquals(1972, date5.getYear());
        Assertions.assertEquals(12, date5.getMonth());
        Assertions.assertEquals(29, date5.getDay());
    }
}
