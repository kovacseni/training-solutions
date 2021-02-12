package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

public class ConsonantVowelEtcCounter {

    public ConsonantVowelEtc countAll(Reader reader) {
        ConsonantVowelEtc cve = new ConsonantVowelEtc(0, 0, 0);

        try (BufferedReader br = new BufferedReader(reader)) {
            int ch;
            while ((ch = br.read()) >= 0) {
                count(ch, cve);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.",ioe);
        }

        return cve;
    }

    private void count(int ch, ConsonantVowelEtc cve) {
        String consonants = "bBcCdDfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXyYzZ";
        String vowels = "aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ";

        if (consonants.indexOf((char)ch) >= 0) {
            cve.setConsonant();
        } else if (vowels.indexOf((char)ch) >= 0) {
            cve.setVowel();
        } else if ((char)ch != ' ') {
            cve.setEtc();
        }
    }

    public void countWithStreams(Path path) {
        String consonants = "bBcCdDfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXyYzZ";
        String vowels = "aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ";

        try {
            IntStream s1 = Files.lines(path).flatMapToInt(String::chars);
            ConsonantVowelEtcEnum.CONSONANT.setCount((int)s1.filter(c -> consonants.indexOf(c) >= 0).count());
            s1.close();

            IntStream s2 = Files.lines(path).flatMapToInt(String::chars);
            ConsonantVowelEtcEnum.VOWEL.setCount((int)s2.filter(c -> vowels.indexOf(c) >= 0).count());
            s2.close();

            IntStream s3 = Files.lines(path).flatMapToInt(String::chars);
            ConsonantVowelEtcEnum.ETC.setCount((int)s3.filter(c -> consonants.indexOf(c) < 0 && vowels.indexOf(c) < 0 && c != ' ').count());
            s3.close();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
