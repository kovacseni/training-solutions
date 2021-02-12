package week15d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class ConsonantVowelEtcCounterTest {

    @Test
    public void testCountAll() throws IOException {
        InputStream is = ConsonantVowelEtcCounterTest.class.getResourceAsStream("/characters.txt");
        InputStreamReader isr = new InputStreamReader(is);
        ConsonantVowelEtc cve = new ConsonantVowelEtcCounter().countAll(isr);

        Assertions.assertEquals(66, cve.getConsonant());
        Assertions.assertEquals(28, cve.getVowel());
        Assertions.assertEquals(47, cve.getEtc());
    }

    @Test
    public void testCountWithStreams() throws IOException {
        Path path = Path.of("src/test/resources/characters.txt");
        new ConsonantVowelEtcCounter().countWithStreams(path);

        Assertions.assertEquals(66, ConsonantVowelEtcEnum.CONSONANT.getCount());
        Assertions.assertEquals(28, ConsonantVowelEtcEnum.VOWEL.getCount());
        Assertions.assertEquals(27, ConsonantVowelEtcEnum.ETC.getCount());
    }
}
