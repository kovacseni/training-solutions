package week13d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> map, BufferedWriter writer) {
        List<String> toWrite = readFromFile(reader, map);
        try {
            for (String s : toWrite) {
                writer.write(s);
                writer.write("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    private List<String> readFromFile(BufferedReader reader, Map<String, Object> map) {
        List<String> toWrite = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String changed = change(line, map);
                toWrite.add(changed);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return toWrite;
    }

    private String change(String line, Map<String, Object> map) {
        if (line.contains("{nev}")) {
            line = replace(line, "{nev}", map);
        }
        else if (line.contains("{datum}")) {
            line = replace(line, "{datum}", map);
        }
        else if (line.contains("{osszeg}")) {
            line = replace(line, "{osszeg}", map);
        }
        else if (line.contains("{hatarido}")) {
            line = replace(line, "{hatarido}", map);
        }

        return line;
    }

    private String replace(String line, String word, Map<String, Object> map) {
        String toReplace = map.get(word).toString();
        line = line.replace(word, toReplace);
        return line;
    }

    public static void main(String[] args) {
        TemplateEngine t = new TemplateEngine();
        Path path1 = Path.of("src/main/resources/letter.txt");
        Path path2 = Path.of("src/main/resources/kedvesugyfel.txt");
        try (BufferedReader br = Files.newBufferedReader(path1);
             BufferedWriter bw = Files.newBufferedWriter(path2))
        {
            Map<String, Object> map = new HashMap<>();
            map.put("{nev}", "Kovács József");
            map.put("{datum}", LocalDate.of(2021, 1, 23));
            map.put("{osszeg}", 18753);
            map.put("{hatarido}", LocalDate.of(2021, 2, 15));

            t.merge(br, map, bw);
        } catch (IOException ioe) {
            throw new IllegalStateException("Error while merging template.", ioe);
        }
    }
}
