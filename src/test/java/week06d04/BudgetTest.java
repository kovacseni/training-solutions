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
        itemList = new ArrayList<>();
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
    public void testBudget1() {
        Assertions.assertEquals(3, budget.getItemsByMonth(2).size());
    }

    @Test
    public void testBudget2() {
        Assertions.assertEquals("vízszámla", budget.getItemsByMonth(2).get(1).getName());
    }

    @Test
    public void testBudget3() {
        Assertions.assertEquals(12500, budget.getItemsByMonth(2).get(0).getPrice());
    }
}
