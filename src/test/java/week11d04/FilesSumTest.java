package week11d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilesSumTest {

    @Test
    public void testSumNumbers() {
        Assertions.assertEquals(393, new FilesSum().sumNumbers());
    }
}