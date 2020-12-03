package week06d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BudgetTest {

    private List<Item> itemList;
    private Budget budget;

    @BeforeEach
    public void setUp() {
        budget = new Budget(itemList);

        Item item1 = new Item(12500, 2, "gázszámla");
        Item item2 = new Item(2500, 2, "vízszámla");
        Item item3 = new Item(112500, 3, "kaja");
        Item item4 = new Item(4000, 2, "könyvvásárlás");
        Item item5 = new Item(10000, 8, "iskolatáska");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
    }

    @Test
    public void testBudget() {
        Assertions.assertEquals(19000, budget.getItemsByMonth(2));
    }
}
