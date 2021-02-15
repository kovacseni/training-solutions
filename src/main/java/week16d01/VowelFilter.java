package week16d01;

import java.io.BufferedReader;
import java.io.IOException;

public class VowelFilter {

    public String filterVowels(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String filtered = filter(line);
                sb.append(filtered).append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return sb.toString().trim();
    }

    public String filter(String line) {
        String vowels = "aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ";
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            if (vowels.indexOf(line.charAt(i)) < 0) {
                result += line.charAt(i);
            }
        }
        return result;
    }
}
