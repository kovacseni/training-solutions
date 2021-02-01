package week12d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoodsPackerTest {

    @Test
    public void testGoodsPacker() {
        int[][] goods = new int[][] {{7, 160}, {3, 90}, {2, 15}};
        Assertions.assertEquals(555, new GoodsPacker().packGoods(goods, 20));
    }
}
