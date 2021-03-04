package covid.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CheckTest {

    private Check check = new Check();

    @Test
    public void checkName() {
        Assertions.assertTrue(check.checkName("Józsi"));
        Assertions.assertFalse(check.checkName(null));
    }

    @Test
    public void checkPostalCode() {
        Assertions.assertTrue(check.checkPostalCode("1234"));
        Assertions.assertFalse(check.checkPostalCode(""));
    }

    @Test
    public void checkAgeIsNumber() {
        Assertions.assertTrue(check.checkAgeIsNumber("45"));
        Assertions.assertFalse(check.checkAgeIsNumber("6m3"));
    }

    @Test
    public void checkAge() {
        Assertions.assertTrue(check.checkAge(23));
        Assertions.assertFalse(check.checkAge(2));
        Assertions.assertFalse(check.checkAge(156));
    }

    @Test
    public void checkEmail() {
        Assertions.assertTrue(check.checkEmail("cd@"));
        Assertions.assertFalse(check.checkEmail("abc"));
        Assertions.assertFalse(check.checkEmail("kovacs.xyz.hu"));
    }

    @Test
    public void checkEmail2() {
        Assertions.assertTrue(check.checkEmail2("a@b", "a@b"));
        Assertions.assertFalse(check.checkEmail2("a@b", "ab@"));
        Assertions.assertFalse(check.checkEmail2("a@b", "@ab"));
    }

    @Test
    public void checkSsn() {
        Assertions.assertTrue(check.checkSsn("111111110"));
        Assertions.assertFalse(check.checkSsn("111111111"));
        Assertions.assertFalse(check.checkSsn("111"));
        Assertions.assertFalse(check.checkSsn("111m11111"));
        Assertions.assertFalse(check.checkSsn("1234567890"));
    }

    @Test
    public void checkDate() {
        Assertions.assertTrue(check.checkDate(null, LocalDate.of(2021, 3, 2)));
        Assertions.assertTrue(check.checkDate(LocalDate.of(2021, 2, 14), LocalDate.of(2021, 3, 2)));
        Assertions.assertFalse(check.checkDate(LocalDate.of(2021, 2, 28), LocalDate.of(2021, 3, 2)));
    }
}