package week06d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordEraserTest {

    @Test
    public void test() {
        Assertions.assertEquals("körte barack szilva körte birsalma", new WordEraser().eraseWord("alma körte barack alma szilva körte birsalma", "alma"));
    }
}
