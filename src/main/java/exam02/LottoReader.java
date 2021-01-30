package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            loadNumbers(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumber(int number) {
        return numbers[number - 1];
    }

    private void loadNumbers(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(";");
            for (int i = 11; i <= 15; i++) {
                int number = Integer.parseInt(temp[i]);
                numbers[number - 1] += 1;
            }
        }
    }
}
