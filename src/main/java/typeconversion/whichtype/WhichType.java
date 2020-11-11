package typeconversion.whichtype;

import java.util.List;
import java.util.ArrayList;

public class WhichType {

    List<Type> type = new ArrayList<>();

    public List<Type> whichType(String s) {
        for (Type t : Type.values()) {
            Long l =Long.parseLong(s);
            if (l > t.getMinValue() && l < t.getmaxValue()) {
                type.add(t);
            }
        }
        return type;
    }
}
