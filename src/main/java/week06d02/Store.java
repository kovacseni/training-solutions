package week06d02;

import java.util.List;

public class Store {

    private List<Product> productList;

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public int getProductByCategoryName(String category) {
        int sum = 0;
        for (Product p : productList) {
            if (p.getCategory().equals(category)) {
                sum += 1;
            }
        }
        return sum;
    }
}
