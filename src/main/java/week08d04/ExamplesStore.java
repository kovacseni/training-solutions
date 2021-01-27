package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples(Reader reader) {
        List<String> titles =new ArrayList<>();
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    String title = line.substring(2);
                    titles.add(title);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return titles;
    }
}
