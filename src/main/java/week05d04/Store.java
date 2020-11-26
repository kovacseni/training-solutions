package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int getNumberOfExpired() {
        int expired = 0;
        for (Product p : productList) {
            if (p.getExpiryDate().isBefore(LocalDate.now())) {
                expired ++;
            }
        }
        return expired;
    }

    public static void main(String[] args) {
        Product product1 = new Product("alma", 2020, 10, 12);
        Product product2 = new Product("tejföl", 2020, 12, 10);
        Product product3 = new Product("kenyér", 2020, 11, 30);
        Product product4 = new Product("zabpehely", 2021, 5, 26);
        Product product5 = new Product("csoki", 2020, 11, 2);

        Store store = new Store();

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);
        store.addProduct(product5);

        System.out.println(store.getNumberOfExpired());
    }
}
