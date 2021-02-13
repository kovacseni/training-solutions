package week14d03;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final UserFilter filter = new UserFilters().createFilter(Arrays.asList(
                (user) -> user.getAge() > 18,
                (user) -> user.getName().startsWith("A")));

        System.out.println(filter.filter(new ArrayList<>(Arrays.asList(
                new User("Marton", 16, "Racz Aladar utca 99/b"),
                new User("Attila", 19, "Kazmer utca 4"),
                new User("Anna", 17, "Mezo utca 5"),
                new User("Kati", 35, "Kossuth utca 4"),
                new User("Aladar", 42, "Petofi utca 6")))));
    }
}
