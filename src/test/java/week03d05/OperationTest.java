package week03d05;

import org.junit.jupiter.api.Test;
import week03d05.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
     void test() {
        //Given
        Operation operation = new Operation("123 + 234");
        //When
        operation.getResult();
        //Then
        assertEquals(357, operation.getResult());
    }
}
