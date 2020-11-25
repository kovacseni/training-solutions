package week05d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

    private List<User> listUser1 = new ArrayList<>();
    private List<User> listUser2 = new ArrayList<>();
    private List<User> listUser3 = new ArrayList<>();
    private List<User> listUser4 = new ArrayList<>();
    private List<User> listUser5 = new ArrayList<>();
    private List<User> listUser6 = new ArrayList<>();
    private List<User> listUser7 = new ArrayList<>();
    private List<User> listUser8 = new ArrayList<>();

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
        User user9 = new User("", -1);

        listUser1.add(user1);
        listUser1.add(user2);

        listUser2.add(user1);
        listUser2.add(user2);
        listUser2.add(user3);

        listUser3.add(user1);
        listUser3.add(user2);
        listUser3.add(user4);

        listUser4.add(user1);
        listUser4.add(user2);
        listUser4.add(user5);

        listUser5.add(user1);
        listUser5.add(user2);
        listUser5.add(user6);

        listUser6.add(user1);
        listUser6.add(user2);
        listUser6.add(user7);

        listUser7.add(user1);
        listUser7.add(user2);
        listUser7.add(user8);

        listUser8.add(user1);
        listUser8.add(user2);
        listUser8.add(user9);
    }

    @Test
    public void testUserValidator1() {
        assertEquals("Users are valid.", new UserValidator().validate(listUser1));
    }

    @Test
    public void testUserValidator2() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new UserValidator().validate(listUser2);
        });
        assertEquals("Az életkornak 0 és 120 közé kell esnie!", ex.getMessage());
    }

    @Test
    public void testUserValidator3() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new UserValidator().validate(listUser3);
        });
        assertEquals("Az életkornak 0 és 120 közé kell esnie!", ex.getMessage());
    }

    @Test
    public void testUserValidator4() {
        assertEquals("Users are valid.", new UserValidator().validate(listUser4));
    }

    @Test
    public void testUserValidator5() {
        assertEquals("Users are valid.", new UserValidator().validate(listUser5));
    }

    @Test
    public void testUserValidator6() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new UserValidator().validate(listUser6);
        });
        assertEquals("A név nem lehet üres!", ex.getMessage());
    }

    @Test
    public void testUserValidator7() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new UserValidator().validate(listUser7);
        });
        assertEquals("A név nem lehet üres!", ex.getMessage());
    }

    @Test
    public void testUserValidator8() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new UserValidator().validate(listUser8);
        });
        assertEquals("A név nem lehet üres!", ex.getMessage());
    }
}
