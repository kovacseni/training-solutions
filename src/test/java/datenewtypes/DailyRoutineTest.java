package datenewtypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DailyRoutineTest {

    @Test
    public void testSetFutureTimeAndIsBeforeNoonWithFirstConstrustor() {
        DailyRoutine dr1 = new DailyRoutine(9, 5);
        dr1.setFutureTime(160);

        Assertions.assertTrue(dr1.isBeforeNoon());
    }

    @Test
    public void testSetFutureTimeAndIsBeforeNoonWithSecondConstrustor() {
        DailyRoutine dr2 = new DailyRoutine("09:30");
        dr2.setFutureTime(160);

        Assertions.assertFalse(dr2.isBeforeNoon());
    }
}
