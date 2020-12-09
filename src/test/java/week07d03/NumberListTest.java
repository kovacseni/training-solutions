package week07d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NumberListTest {

    private List<Integer> list1;
    private List<Integer> list2;
    private List<Integer> list3;
    private List<Integer> list4;
    private List<Integer> list5;

    @BeforeEach
    public void setUp() {
        list1 = Arrays.asList(1, 2, 3, 3, 3, 5);
        list2 = Arrays.asList(3, 3, 4, 5, 5, 4);
        list3 = Arrays.asList(1, 2, 3, 4, 5);
        list4 = Arrays.asList(-4, -2, 0, 1, 2);
        list5 = Arrays.asList(2, 3, 4, 4, -5, -4);
    }

    @Test
    public void testList1() {
        Assertions.assertEquals(true, new NumberList().isIncreasing(list1));
    }

    @Test
    public void testList2() {
        Assertions.assertEquals(false, new NumberList().isIncreasing(list2));
    }

    @Test
    public void testList3() {
        Assertions.assertEquals(true, new NumberList().isIncreasing(list3));
    }

    @Test
    public void testList4() {
        Assertions.assertEquals(true, new NumberList().isIncreasing(list4));
    }

    @Test
    public void testList5() {
        Assertions.assertEquals(false, new NumberList().isIncreasing(list5));
    }
}
