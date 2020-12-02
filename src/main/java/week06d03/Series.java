package week06d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Series {

    public String calculateSeriesType(List<Integer> numberList) {
        if (numberList == null || numberList.size() <= 1) {
            throw new IllegalArgumentException("Nem értelmezhető a lista!");
        }

        List<Integer> negativeDiffList = new ArrayList<>();
        List<Integer> positiveDiffList = new ArrayList<>();

        for (int i = 0; i < numberList.size() - 1; i++) {
            int diff = (numberList.get(i+1) - numberList.get(i));
            if (diff < 0) {
                negativeDiffList.add(diff);
            } else if (diff > 0) {
                positiveDiffList.add(diff);
            }
        }

        String result = null;
        if (positiveDiffList.size() > 0 && negativeDiffList.size() == 0) {
            result = "Növekvő sorozat.";
        } else if (positiveDiffList.size() == 0 && negativeDiffList.size() > 0) {
            result = "Csökkenő sorozat.";
        } else if (positiveDiffList.size() > 0 && negativeDiffList.size() > 0) {
            result = "Összevissza sorozat.";
        }

        return result;
    }
}
