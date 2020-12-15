package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    private List<Integer> lotteryList = new ArrayList<>(5);

    public List<Integer> getNumbers() {
        Random random = new Random(1);
        int lotteryNumber = random.nextInt(90) + 1;
        for (int i = 1; i <= 5; i++) {
            while (lotteryList.contains(lotteryNumber)) {
                lotteryNumber = random.nextInt(90) + 1;
            }
            lotteryList.add(lotteryNumber);
        }
        return lotteryList;
    }
}
