package week02d03;

public class Product {

    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p) {
        return name.equals(p.name);
    }

    public static void main(String[] args) {

        Product p1 = new Product("ruha", "1234");
        Product p2 = new Product("cipő", "12345");
        Product p3 = new Product("ruha", "12345");

        System.out.println(p1.areTheyEqual(p2));
        System.out.println(p1.areTheyEqual(p3));



    }
}
