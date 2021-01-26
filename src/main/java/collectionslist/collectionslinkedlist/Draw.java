package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less than " + maxNumber + "!");
        }

        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        Set<Integer> winningNumbers = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            winningNumbers.add(numbers.get(i));
        }

        return winningNumbers;
    }
}
