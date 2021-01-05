package week10d02;

import java.util.Arrays;
import java.util.List;

public class  MaxTravel {

    public int getMaxIndex(List<Integer> busStop) {
        int[] stops =  new int[30];
        for (int i = 0; i < busStop.size(); i++) {
            int stop = busStop.get(i);
            stops[stop] += 1;
        }

        int max = stops[0];
        int index = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[i] > max) {
                max = stops[i];
                index = i;
            }
        }
        return index;
    }
}
