package week14d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

public class HachikoTest {

    @Test
    public void testCountWords() throws IOException {
        try (FileReader fr = new FileReader("src/main/resources/hachiko.srt", Charset.forName("windows-1250"))) {
            Map<String, Integer> wordsSum = new Hachiko().countWords(fr, "Hachiko", "haza", "pályaudvar", "jó");

            Assertions.assertEquals(16, wordsSum.get("haza"));
            Assertions.assertEquals(4, wordsSum.get("Hachiko"));
            Assertions.assertEquals(38, wordsSum.get("jó"));
            Assertions.assertEquals(6, wordsSum.get("pályaudvar"));
        }
    }
}
