package week05d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    private Store store;

    @BeforeEach
    public void setUp() {
        Product product1 = new Product("alma", 2020, 10, 12);
        Product product2 = new Product("tejföl", 2020, 12, 10);
        Product product3 = new Product("kenyér", 2020, 11, 30);
        Product product4 = new Product("zabpehely", 2021, 5, 26);
        Product product5 = new Product("csoki", 2020, 11, 2);

        store = new Store();

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);
        store.addProduct(product5);
    }

    @Test
    public void storeTest() {
        assertEquals(2, store.getNumberOfExpired());
    }
}
