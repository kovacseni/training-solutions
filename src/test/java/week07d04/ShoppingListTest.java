package week07d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingListTest {

    @Test
    public void testMethod() {
        Assertions.assertEquals(3730, new ShoppingList().calculateSum("/shoppinglist.txt") );
    }
}
