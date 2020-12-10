package week07d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LabTest {

    @Test
    public void testConstructor1() {
        Lab lab1 = new Lab("Töri házi");
        Assertions.assertEquals("Töri házi", lab1.getTitle());
        Assertions.assertFalse(lab1.getCompleted());
        Assertions.assertEquals(null, lab1.getCompletedAt());
    }

    @Test
    public void testConstructor2() {
        Lab lab2 = new Lab("Töri házi", LocalDate.of(2020, 11, 10));
        Assertions.assertEquals("Töri házi", lab2.getTitle());
        Assertions.assertTrue(lab2.getCompleted());
        Assertions.assertEquals(LocalDate.of(2020, 11, 10), lab2.getCompletedAt());
    }

    @Test
    public void testComplete1() {
        Lab lab3 = new Lab("Töri házi");
        lab3.complete(LocalDate.of(2020, 10, 11));
        Assertions.assertEquals("Töri házi", lab3.getTitle());
        Assertions.assertTrue(lab3.getCompleted());
        Assertions.assertEquals(LocalDate.of(2020, 10, 11), lab3.getCompletedAt());
    }

    @Test
    public void testComplete2() {
        Lab lab4 = new Lab("Töri házi");
        lab4.complete();
        Assertions.assertEquals("Töri házi", lab4.getTitle());
        Assertions.assertTrue(lab4.getCompleted());
        Assertions.assertEquals(LocalDate.of(2020, 12, 10), lab4.getCompletedAt());
    }
}
