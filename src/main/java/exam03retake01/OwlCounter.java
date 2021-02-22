package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owlsByCounty = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split("=");
                owlsByCounty.put(temp[0], Integer.parseInt(temp[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {
        return owlsByCounty.get(county);
    }
}
