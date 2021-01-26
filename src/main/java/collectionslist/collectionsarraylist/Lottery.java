package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (ballCount <= lotteryType) {
            throw new IllegalArgumentException("Balls must be more than the winning numbers!");
        }

        List<Integer> balls = new ArrayList<>();
        for (int i = 1; i <= ballCount; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            winningNumbers.add(balls.get(i));
        }
        Collections.sort(winningNumbers);

        return winningNumbers;
    }
}
