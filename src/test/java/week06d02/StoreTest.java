package week06d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {

    private List<Product> productList;
    private Store store;

    @BeforeEach
    public void setUp() {
        productList = new ArrayList<>();
        store = new Store(productList);
        productList.add(new Product("kenyér", "bakedgoods", 325));
        productList.add(new Product("tej", "dairy", 250));
        productList.add(new Product("csirkemell", "dairy", 1500));
        productList.add(new Product("kifli", "bakedgoods", 30));
        productList.add(new Product("tejföl", "dairy", 300));
        productList.add(new Product("zsömle", "bakedgoods", 30));
        productList.add(new Product("kutyakaja", "other", 3500));
        productList.add(new Product("tusfürdő", "other", 750));
        productList.add(new Product("fogkefe", "other", 300));
        productList.add(new Product("ruha", "other", 5400));
    }

    @Test
    public void testStore() {
        Assertions.assertEquals(3, store.getProductByCategoryName("dairy"));
    }
}
