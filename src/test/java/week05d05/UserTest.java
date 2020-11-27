package week05d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void atTest() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new User("Jóska", "Pista", "joskapistagmail.com");
        });
        Assertions.assertEquals("Az e-mail cím nem megfelelő!", ex.getMessage());
    }

    @Test
    public void dotTest() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new User("Jóska", "Pista", "joskapista@gmailcom");
        });
        Assertions.assertEquals("Az e-mail cím nem megfelelő!", ex.getMessage());
    }

    @Test
    public void fullNameTest() {
        Assertions.assertEquals("Jóska Pista", new User("Jóska", "Pista", "joskapista@gmail.com").getFullName());
    }
}
