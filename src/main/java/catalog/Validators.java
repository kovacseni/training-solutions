package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String str) {
        return (str == null || "".equals(str) || str.isBlank());
    }

    public static boolean isEmpty(List list) {
        return (list == null || list.size() == 0);
    }
}
