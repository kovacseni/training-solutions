package week07d03;

import java.util.List;

public class NumberList {

    public boolean isIncreasing(List<Integer> intList) {

        boolean increasing = true;
        int inc = intList.get(0);
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) >= inc) {
                inc = intList.get(i);
            } else if (intList.get(i) < inc) {
                increasing = false;
            }
        }
        return increasing;
    }
}
