package week06d01;

import java.util.List;

public class ListSelector {

    public String selectEveryEvenElement(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Nem értelmezhető a lista!");
        }

        String even = "";
        for (int i = 0; i < list.size(); i += 2) {
           even = even + list.get(i);
        }

        if (!even.equals("")) {
            even = "[" + even + "]";
        }

        return even;
    }

    public String selectEveryOddElement(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Nem értelmezhető a lista!");
        }

        String odd = "";
        for (int i = 1; i < list.size(); i += 2) {
            odd = odd + list.get(i) + ", ";
        }

        if (!odd.equals("")) {
            odd = odd.substring(0, (odd.length() - 2));
            odd = "[" + odd + "]";
        }

        return odd;
    }
}
