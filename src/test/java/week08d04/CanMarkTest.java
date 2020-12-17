package week08d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanMarkTest {

    @Test
    public void trainerTest() {
        Assertions.assertEquals(5, new Trainer(new GoodMood()).giveMark());
        Assertions.assertEquals(3, new Trainer(new BadMood()).giveMark());
    }
}
