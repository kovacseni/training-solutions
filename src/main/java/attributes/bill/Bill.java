package attributes.bill;

import java.util.List;
import java.util.ArrayList;

public class Bill {

    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println(item.getProduct() + ", " + item.getQuantity() + ", " + item.getPrice());
        }
return items;
    }

    public double calculateTotalPrice() {
        double vegOsszeg = 0;

        for (Item item : items) {
            double reszOsszeg = item.getQuantity() * item.getPrice();
            vegOsszeg = vegOsszeg + reszOsszeg;
        }
        return vegOsszeg;
    }
}
