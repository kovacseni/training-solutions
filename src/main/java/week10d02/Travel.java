package week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Travel {

    public int getStopWithMax(InputStream is) {
        int stop = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            int[] stops = new int[30];
            int max= 0;
            String line;
            while ((line = br.readLine()) != null) {
                String stopString = line.substring(0, line.indexOf(" "));
                int stopNumber = Integer.parseInt(stopString);
                stops[stopNumber] += 1;
            }
            for (int i = 0; i < stops.length; i++) {
                if (stops[i] > max) {
                    max = stops[i];
                    stop = i;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return stop;
    }
}
