package week06d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeriesTest {

    private List<Integer> list1;
    private List<Integer> list2;
    private List<Integer> list3;
    private List<Integer> list4;
    private List<Integer> list5;

    @BeforeEach
    public void setUp() {
        list1 = Arrays.asList(1, 2, 3, 4, 5);
        list2 = Arrays.asList(5, 4, 3, 2, 1);
        list3 = Arrays.asList(5, 2, 4, 1, 3);
        list4 = new ArrayList<>();
        list5 = Arrays.asList(1);
    }

    @Test
    public void testList1() {
        Assertions.assertEquals("Növekvő sorozat.", new Series().calculateSeriesType(list1));
    }

    @Test
    public void testList2() {
        Assertions.assertEquals("Csökkenő sorozat.", new Series().calculateSeriesType(list2));
    }

    @Test
    public void testList3() {
        Assertions.assertEquals("Összevissza sorozat.", new Series().calculateSeriesType(list3));
    }

    @Test
    public void testList4() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Series().calculateSeriesType(list4);
    });
        assertEquals("Nem értelmezhető a lista!", ex.getMessage());
    }

    @Test
    public void testList5() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Series().calculateSeriesType(list5);
        });
        assertEquals("Nem értelmezhető a lista!", ex.getMessage());
    }
}
