package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    List<String> list1 = Arrays.asList("Alma", "körte", "Barack", "autó", "gépkocsi");
    List<String> list2 = Arrays.asList("füge", "körte", "Barack", "tojás", "gépkocsi");
    List<String> list3 = new ArrayList<>();

    @Test
    public void listCounterTest1() {
        assertEquals(2, new ListCounter().count(list1));
    }

    @Test
    public void listCounterTest2() {
        assertEquals(0, new ListCounter().count(list2));
    }

    @Test
    public void listCounterTest3() {
        assertEquals(0, new ListCounter().count(list3));
    }
}
