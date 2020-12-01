package week06d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductSeniorTest {

    private List<ProductSenior> productList;
    private Store store;

    @BeforeEach
    public void setUp() {
        productList = new ArrayList<>();
        store = new Store(productList);
        productList.add(new ProductSenior("kenyér", Category.BAKEDGOODS, 325));
        productList.add(new ProductSenior("tej", Category.DAIRY, 250));
        productList.add(new ProductSenior("csirkemell", Category.FROZEN, 1500));
        productList.add(new ProductSenior("kifli", Category.BAKEDGOODS, 30));
        productList.add(new ProductSenior("tejföl", Category.DAIRY, 300));
        productList.add(new ProductSenior("zsömle", Category.BAKEDGOODS, 30));
        productList.add(new ProductSenior("kutyakaja", Category.OTHER, 3500));
        productList.add(new ProductSenior("tusfürdő", Category.OTHER, 750));
        productList.add(new ProductSenior("fogkefe", Category.OTHER, 300));
        productList.add(new ProductSenior("ruha", Category.OTHER, 5400));
    }

    @Test
    public void testGetProductsByCategory() {
        Assertions.assertEquals("Fagyasztott áru: 1 db. Tejtermék: 2 db. Pékáru: 3 db. Egyéb: 4 db.", store.getProductsByCategory());
    }
}
