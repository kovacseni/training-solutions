package week12d01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GoodsPacker {

    public int packGoods (int[][] types, int capacity) {
        List<Good> goods = loadGoods(types);
        Collections.sort(goods, Comparator.comparingInt(Good::getRate));
        Collections.reverse(goods);
        int sumValue = 0;
        int cap = 0;
        for (Good g : goods) {
            while ((cap + g.getKg()) <= capacity) {
                sumValue += g.getValue();
                cap += g.getKg();
            }
        }
        return sumValue;
    }

    private List<Good> loadGoods(int[][] types) {
        List<Good> goods = new ArrayList<>();
        for (int[] i : types) {
            goods.add(new Good(i[0], i[1]));
        }
        return goods;
    }

    public static void main(String[] args) {
        int[][] types = {{7, 160}, {3, 90}, {2, 15}};
        System.out.println(new GoodsPacker().packGoods(types, 20));
    }
}
