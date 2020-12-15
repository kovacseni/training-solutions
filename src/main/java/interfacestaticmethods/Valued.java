package interfacestaticmethods;

import java.util.List;

public interface Valued {

    static double totalValue(List<Valued> items) {
        double result = 0;
        for (Valued v : items) {
            result += v.getValue();
        }
        return result;
    }

    double getValue();
}
