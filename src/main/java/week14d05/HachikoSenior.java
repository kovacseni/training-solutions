package week14d05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class HachikoSenior {

    public int getAllOccurencesOfWord(Path path, String word) {
        try (Stream<String> s = Files.lines(path, Charset.forName("windows-1250")).flatMap(line -> line.lines())) {
            return (int)s.filter(w -> w.contains(word)).count();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
