package week14d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

public class HachikoTest {

    @Test
    public void testCountWords() {
        try (FileReader fr = new FileReader("src/main/resources/hachiko.srt", Charset.forName("windows-1250"))) {
                Map<String, Integer> wordsSum = new Hachiko().countWords(fr, "Hachiko", "haza", "pályaudvar", "jó");

            Assertions.assertEquals("{haza=15, Hachiko=4, jó=15, pályaudvar=5}", wordsSum.toString());

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
