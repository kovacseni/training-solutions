package week06d04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    private List<ItemSenior> shoppingList;
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        shoppingList = new ArrayList<>();
        cart = new ShoppingCart(shoppingList);

        ItemSenior item1 = new ItemSenior("kenyér", 1);
        ItemSenior item2 = new ItemSenior("tej", 2);
        ItemSenior item3 = new ItemSenior("joghurt", 3);
        ItemSenior item4 = new ItemSenior("zsömle", 4);
        ItemSenior item5 = new ItemSenior("tojás", 5);

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
