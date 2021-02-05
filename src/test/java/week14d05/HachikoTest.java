package week14d05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

public class HachikoTest {

    @Test
    public void testCountWords() {
        try (InputStream is = HachikoTest.class.getResourceAsStream("src/main/resources/hachiko.srt");
             InputStreamReader isr = new InputStreamReader(is, Charset.forName("windows-1250"))) {
                Map<String, Integer> wordsSum = new Hachiko().countWords(isr, "Hachiko", "haza", "pályaudvar", "jó");
                System.out.println(wordsSum.toString());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
