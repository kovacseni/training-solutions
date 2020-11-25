package week05d03;

import java.util.List;

public class UserValidator {

    public String validate(List<User> userList) {
        for (User u : userList) {
            if (u.getName() == null || "".equals(u.getName()) || u.getName().isBlank()) {
                throw new IllegalArgumentException("A név nem lehet üres!");
            }

            if (u.getAge() < 0 || u.getAge() > 120) {
                throw new IllegalArgumentException("Az életkornak 0 és 120 közé kell esnie!");
            }
        }
        return "Users are valid.";
    }
}
