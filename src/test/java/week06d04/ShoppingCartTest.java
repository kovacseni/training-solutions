package week06d04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    private List<Item> shoppingList;
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        shoppingList = new ArrayList<>();
        cart = new ShoppingCart(shoppingList);

        Item item1 = new Item("kenyér", 1);
        Item item2 = new Item("tej", 2);
        Item item3 = new Item("joghurt", 3);
        Item item4 = new Item("zsömle", 4);
        Item item5 = new Item("tojás", 5);

        shoppingList.add(item1);
        shoppingList.add(item2);
        shoppingList.add(item3);
        shoppingList.add(item4);
        shoppingList.add(item5);
    }

    @AfterEach
    public void backToDefault() {
        shoppingList = null;
        cart = null;
    }

    @Test
    public void testGetItem() {
        Assertions.assertEquals(3, cart.getItem("joghurt"));
    }

    @Test
    public void testSetQuantity() {
        cart.addItem("tej", 2);
        Assertions.assertEquals(4, cart.getItem("tej"));
    }

    @Test
    public void testAdditem() {
        cart.addItem("fogkrém", 1);
        Assertions.assertEquals(1, cart.getItem("fogkrém"));
    }

    @Test
    public void testAddItemAndGetName() {
        cart.addItem("alma", 3);
        Assertions.assertEquals("alma", shoppingList.get(5).getName());
    }

    @Test
    public void testAddItemAndThenSetQuantity() {
        cart.addItem("csoki", 2);
        cart.addItem("csoki", 3);
        Assertions.assertEquals(5, cart.getItem("csoki"));
    }

}
