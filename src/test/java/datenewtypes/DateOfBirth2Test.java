package datenewtypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateOfBirth2Test {

    @Test
    public void testFindDayOfWeek() {
        Assertions.assertEquals("szombat", new DateOfBirth2(1981, 12, 19).findDayOfWeek());
    }

    @Test
    public void testIsWeekDay() {
        Assertions.assertFalse(new DateOfBirth2(1981, 12, 19).isWeekDay());
        Assertions.assertTrue(new DateOfBirth2(1981, 12, 21).isWeekDay());
    }

    @Test
    public void testWasItALeapYear() {
        Assertions.assertFalse(new DateOfBirth2(1981, 12, 21).wasItALeapYear());
        Assertions.assertTrue(new DateOfBirth2(1984, 1, 2).wasItALeapYear());
    }

    @Test
    public void testFindBirthDayOfWeekLater() {
        Assertions.assertEquals("vasárnap", new DateOfBirth2(1981, 12, 19).findBirthDayOfWeekLater(2021));
    }
}
