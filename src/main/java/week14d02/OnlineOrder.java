package week14d02;

import java.util.ArrayList;
import java.util.List;

public class OnlineOrder {

    private String id;
    private List<Product> products;

    public OnlineOrder(String id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public String toString() {
        return id + products.toString();
    }
}
