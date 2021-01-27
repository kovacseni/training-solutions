package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Teacher {

    public int getNumber(Reader reader, String teacherName) {
        try (BufferedReader br = new BufferedReader(reader)) {
           return count(br, teacherName);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private int count(BufferedReader br, String teacherName) throws IOException {
        int sum = 0;
        String line;
        while ((line = br.readLine()) != null) {
            skipTwoLines(br);
            int number = Integer.parseInt(br.readLine());
            if (line.equals(teacherName)) {
                sum += number;
            }
        }
        return sum;
    }

    private void skipTwoLines(BufferedReader br) throws IOException {
        br.readLine();
        br.readLine();
    }
}
