package introinheritance.basket;

import java.util.List;

public class ShoppingBasket {

    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getNettoPrice() + i.getTaxAmount();
        }
        return sum;
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        List<Item> items = basket.getItems();
        Item mostExpensiveItem = items.get(0);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNettoPrice() > mostExpensiveItem.getNettoPrice()) {
                mostExpensiveItem = items.get(i);
            }
        }

        basket.removeItem(mostExpensiveItem.getBarcode());
    }
}
