package week05d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductSeniorTest {

    ProductSenior p1 = new ProductSenior(600, Currency.HUF);
    ProductSenior p2 = new ProductSenior(6, Currency.USD);

    @Test
    public void testHUF() {
        Assertions.assertEquals(2.0, p1.convertPrice(Currency.USD));
    }

    @Test
    public void testUSD() {
        Assertions.assertEquals(1800.0, p2.convertPrice(Currency.HUF));
    }
}
