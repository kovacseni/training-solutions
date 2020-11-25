package week05.d03;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    private List<User> userList = new ArrayList<>();

    public void validate(List<User> userList) {
        int i = 0;
        while (i < userList.size()) {
            if (userList.get(i).getName() == null || "".equals(userList.get(i).getName()) || userList.get(i).getName().isBlank()) {
                throw new IllegalArgumentException("A név nem lehet üres!");
            } else if (userList.get(i).getAge() > 0 || userList.get(i).getAge() > 120) {
                throw new IllegalArgumentException("Az életkornak 0 és 120 közé kell esnie!");
            }
        }
    }

    public static void main(String[] args) {
        UserValidator userV = new UserValidator();
        List<User> listUser = new ArrayList<>();
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

        userV.validate(listUser);
    }
}
