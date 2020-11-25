package week05.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

    private List<User> listUser = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        User user1 = new User("Jóska", 5);
        User user2 = new User("Pista", 28);
        User user3 = new User("Laci", -51);
        User user4 = new User("Béla", 123);
        User user5 = new User("Geri", 0);
        User user6 = new User("Bali", 120);
        User user7 = new User("", 54);
        User user8 = new User(null, 67);

        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);
        listUser.add(user5);
        listUser.add(user6);
        listUser.add(user7);
        listUser.add(user8);
    }

    @Test
    public void testUserValidator() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new UserValidator().validate(listUser);
        });
    }
}
