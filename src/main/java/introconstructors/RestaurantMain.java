package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Enni-kék", 12);

        restaurant.addMenu("Cordon Bleu");
        restaurant.addMenu("Bécsi szelet");
        restaurant.addMenu("Halászlé");
        restaurant.addMenu("Marhagulyás");
        restaurant.addMenu("Túrós palacsinta");
        restaurant.addMenu("Somlói galuska");

        System.out.println(restaurant.getName());
        System.out.println(restaurant.getCapacity());
        System.out.println(restaurant.getMenu());
    }
}
