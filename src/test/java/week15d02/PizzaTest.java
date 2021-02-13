package week15d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class PizzaTest {

    private Pizza pizza = new Pizza();

    @BeforeEach
    public void setUp() {
        InputStream is = Pizza.class.getResourceAsStream("/orders.txt");
        InputStreamReader isr = new InputStreamReader(is);
        pizza.loadFromFile(isr);
    }

    @Test
    public void testGetDayWithLeastOrders() {
        Assertions.assertEquals("2020-12-03", pizza.getDayWithLeastOrders().toString());
    }

    @Test
    public void testGetExactOrder() {
        Assertions.assertEquals("1088 Dob 2 10:30", pizza.getExactOrder(LocalDate.of(2020, 12, 2), LocalTime.of(10, 30)).toString());
    }

    @Test
    public void testGetCourierStatistics() {
        Map<String, Integer> expected = pizza.getCourierStatistics();

        Assertions.assertEquals(7, expected.get("FUT_1"));
        Assertions.assertEquals(5, expected.get("FUT_2"));
        Assertions.assertEquals(2, expected.get("FUT_3"));
        Assertions.assertEquals(2, expected.get("FUT_4"));
    }

    @Test
    public void testGetAddressWithMostOrders() {
        Assertions.assertEquals("1114 Kossuth 9", pizza.getAddressWithMostOrders());
    }
}
