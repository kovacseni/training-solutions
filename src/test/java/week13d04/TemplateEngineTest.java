package week13d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateEngineTest {

    @TempDir
    public File folder;

    @Test
    public void TemplateEngineTest() {
        TemplateEngine t = new TemplateEngine();
        Path path1 = Path.of("src/main/resources/letter.txt");
        Path path2 = new File(folder, "kedvesugyfel.txt").toPath();
        try (BufferedReader br = Files.newBufferedReader(path1);
             BufferedWriter bw = Files.newBufferedWriter(path2))
        {
            Map<String, Object> map = new HashMap<>();
            map.put("{nev}", "Kovács József");
            map.put("{datum}", LocalDate.of(2021, 1, 23));
            map.put("{osszeg}", 18753);
            map.put("{hatarido}", LocalDate.of(2021, 2, 15));

            t.merge(br, map, bw);

            List<String> letter = Files.readAllLines(path2);

            Assertions.assertEquals("Kedves Kovács József!", letter.get(0));
            Assertions.assertEquals("Megküldjük önnek a következő esedékes számláját 2021-01-23 dátummal,", letter.get(2));
            Assertions.assertEquals("melynek összege: 18753 Ft!", letter.get(3));
            Assertions.assertEquals("A fizetési határidő 2021-02-15.", letter.get(4));

        } catch (IOException ioe) {
            throw new IllegalStateException("Error while merging template.", ioe);
        }
    }
}
