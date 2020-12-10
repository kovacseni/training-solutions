package week07d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserImplTest {

    @Test
    public void testAll() {
        User u = User.of();
        u = new UserImpl("kicsilany", "Zsófia", "Nagy");

        Assertions.assertEquals("kicsilany", u.getUsername());
        Assertions.assertEquals("Zsófia", u.getFirstName());
        Assertions.assertEquals("Nagy", u.getLastName());
        Assertions.assertEquals("Nagy Zsófia", u.getFullName());
    }
}
