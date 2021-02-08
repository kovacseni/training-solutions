package week15d01;

import java.util.HashMap;
import java.util.Map;

public class Max {

    private Map<Integer, Integer> coordinates;

    public Max(Map<Integer, Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public Map<Integer, Integer> getCoordinates() {
        return new HashMap<>(coordinates);
    }

    public int[] getMax() {
        int x = 0;
        int y = 0;
        for (Integer i : coordinates.keySet()) {
            if (coordinates.get(i) > y) {
                x = i;
                y = coordinates.get(i);
            }
        }
        return new int[] {x, y};
    }
}
