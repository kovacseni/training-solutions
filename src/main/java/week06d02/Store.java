package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<ProductSenior> productList;

    public Store(List<ProductSenior> productList) {
        this.productList = productList;
    }

    public String getProductsByCategory() {
        int frozen = 0;
        int dairy = 0;
        int bakedgoods = 0;
        int other = 0;

        for (ProductSenior p : productList) {
            if (p.getCategory() == Category.FROZEN) {
                frozen = frozen + 1;
            } else if (p.getCategory() == Category.DAIRY) {
                dairy = dairy + 1;
            } else if (p.getCategory() == Category.BAKEDGOODS) {
                bakedgoods = bakedgoods + 1;
            } else if (p.getCategory() == Category.OTHER) {
                other = other + 1;
            }
        }

        ProductSeniorResult productSeniorResult = new ProductSeniorResult(frozen, dairy, bakedgoods, other);
        return productSeniorResult.toString();
    }
}
