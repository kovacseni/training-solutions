package classstructureconstructors;

public class Store {

    private String product;
    private int stock;

    public Store(String product) {
        this.product = product;
        stock = 0;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }

    public void store (int mennyiseg) {
        stock = stock + mennyiseg;
    }

    public void dispatch (int elszallitas) {
        stock = stock - elszallitas;

    }
}
