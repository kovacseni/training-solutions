package week14d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineShoppingTest {

    private OnlineShopping os = new OnlineShopping();
    private Path file = Path.of("src/main/resources/shopping.txt");

    @BeforeEach
    public void setUp() {
        os.readFile(file);
    }

    @Test
    public void getItemById() {
        List<String> result = os.getItemById("B3402");
        assertEquals(List.of("bbq_sauce", "cola", "meat", "soda"), result);
    }

    @Test
    public void getItemByIdReversed() {
        List<String> resultReverse = os.getItemByIdReversed("B3402");
        assertEquals(List.of("soda","meat","cola","bbq_sauce"),resultReverse);
    }

    @Test
    public void getNumberOfItemsSell() {
        int resultCount = os.getNumberOfItemSold("tomato");
        assertEquals(2,resultCount);
    }

    @Test
    public void getNumberOfItemsById() {
        int sizeList = os.getNumberOfItemsById("B3402");
        assertEquals(4,sizeList);
    }

    @Test
    public void shoppingListStatistics() {
        Map<String,Integer> resultMap = os.shoppingListStatistics();
        assertEquals(2,resultMap.get("rosemary").intValue());
        assertEquals(2,resultMap.get("meat").intValue());
        assertEquals(1,resultMap.get("pear").intValue());
    }
}
