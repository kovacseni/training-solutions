package week06d04;

import java.util.List;

public class ShoppingCart {

    private List<ItemSenior> shoppingList;

    public ShoppingCart(List<ItemSenior> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void addItem(String name, int quantity) {
       boolean isOnTheList = false;
       for (int i = 0; i < shoppingList.size(); i++) {
           if (shoppingList.get(i).getName().equals(name)) {
               int q = shoppingList.get(i).getQuantity();
               q += quantity;
               shoppingList.get(i).setQuantity(q);
               isOnTheList = true;
           }
       }

       if (isOnTheList == false) {
           ItemSenior item = new ItemSenior(name, quantity);
           shoppingList.add(item);
       }
    }

    public int getItem(String name) {
        int quantity = 0;
        for (ItemSenior i : shoppingList) {
            if (i.getName().equals(name)) {
                quantity = i.getQuantity();
            }
        }
        return quantity;
    }
}
