package week14d03;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class UserFilters {

    public UserFilter createFilter(List<Predicate<User>> predicates) {
        return users -> {
            final Iterator<User> userIter = users.iterator();
            while (userIter.hasNext()) {
                User user = userIter.next();
                boolean shouldRemove = false;
                for (Predicate<User> p : predicates) {
                    if (!p.test(user)) {
                        shouldRemove = true;
                    }
                }
                if (shouldRemove) {
                    userIter.remove();
                }
            }
            return users;
        };
    }
}
