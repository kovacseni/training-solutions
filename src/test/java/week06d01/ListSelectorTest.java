package week06d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    private List<String> list;
    private List<String> list2 = null;

    @BeforeEach
    public void SetUpList() {
        list = new ArrayList<>();

        list.add("alma");
        list.add("körte");
        list.add("alma");
        list.add("körte");
        list.add("alma");
        list.add("körte");
        list.add("alma");
        list.add("körte");
        list.add("alma");
        list.add("körte");
    }

    @Test
    public void evenTest() {
        Assertions.assertEquals("[almaalmaalmaalmaalma]", new ListSelector().selectEveryEvenElement(list));
    }

    @Test
    public void oddTest() {
        Assertions.assertEquals("[körte, körte, körte, körte, körte]", new ListSelector().selectEveryOddElement(list));
    }

    @Test
    public void emptyListTest() {
        Assertions.assertEquals("", new ListSelector().selectEveryOddElement(new ArrayList<>()));
    }

    @Test
    public void testListSelector() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new ListSelector().selectEveryEvenElement(list2);
        });
        assertEquals("Nem értelmezhető a lista!", ex.getMessage());
    }
}
