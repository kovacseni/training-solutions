package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {

        Store store1 = new Store("számítógép");
        Store store2 = new Store("egér");

        store1.store(15);
        store2.store(326);

        store1.dispatch(2);
        store2.dispatch(35);

        System.out.println(store1.getProduct() + ": " + store1.getStock() + " db");
        System.out.println(store2.getProduct() + ": " + store2.getStock() + " db");
    }
}
