package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String stars = getStars(line);
                sb.append(stars).append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return sb.toString();
    }

    private String getStars(String line) {
        String stars = "";
        int numberOfStars = Integer.parseInt(line);
        for (int i = 0; i < numberOfStars; i++) {
            stars += "*";
        }
        return stars;
    }
}
