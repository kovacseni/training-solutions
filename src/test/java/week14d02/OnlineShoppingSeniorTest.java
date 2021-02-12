package week14d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OnlineShoppingSeniorTest {

    private OnlineShoppingSenior os = new OnlineShoppingSenior();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = OnlineShoppingSenior.class.getResourceAsStream("/shoppingsenior.txt");
        InputStreamReader isr = new InputStreamReader(is);
        os.loadOrders(isr);
    }

    @Test
    public void testGetTotalValueOfOneOrder() {
        Assertions.assertEquals(2550, os.getTotalValueOfOneOrder("11"));
    }

    @Test
    public void testGetTotalValueByCustomerId() {
        Assertions.assertEquals(9650, os.getTotalValueByCustomerId("SM123"));
    }

    @Test
    public void testSortProductsByOrderIdName() {
        Assertions.assertEquals("chicken", os.sortProductsByOrderId("120", SortingType.NAME).get(0).getName());
        Assertions.assertEquals("fish", os.sortProductsByOrderId("120", SortingType.NAME).get(2).getName());
        Assertions.assertEquals("tuna", os.sortProductsByOrderId("120", SortingType.NAME).get(6).getName());
    }

    @Test
    public void testSortProductsByOrderIdPrice() {
        Assertions.assertEquals("chicken", os.sortProductsByOrderId("120", SortingType.PRICE).get(5).getName());
        Assertions.assertEquals("fish", os.sortProductsByOrderId("120", SortingType.PRICE).get(6).getName());
        Assertions.assertEquals("tuna", os.sortProductsByOrderId("120", SortingType.PRICE).get(4).getName());
    }

    @Test
    public void testGetTotalPiecesOfProduct() {
        Assertions.assertEquals(3, os.getTotalPiecesOfProduct("tomato"));
    }

    @Test
    public void testGetProductStatistics() {
        Assertions.assertEquals(2, os.getProductStatistics().get("potato"));
        Assertions.assertEquals(1, os.getProductStatistics().get("Nutella"));
        Assertions.assertEquals(3, os.getProductStatistics().get("bread"));
    }
}
