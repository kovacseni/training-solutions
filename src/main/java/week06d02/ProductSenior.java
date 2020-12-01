package week06d02;

public class ProductSenior {

    private String name;
    private Category category;
    private int price;

    public ProductSenior(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }
}
