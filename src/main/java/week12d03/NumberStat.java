package week12d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStat {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void readNumbers(String filename) {
        Path path = Path.of("src/main/resources/" + filename);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(",");
                addNumbers(splittedLine);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int findSmallestUnique() {
        if (numbers.size() == 0) {
            throw new IllegalStateException("Attribute is empty");
        }
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        if (numbers.get(0) != numbers.get(1)) {
            return numbers.get(0);
        }

        for (int i = 1; i < sortedNumbers.size() - 1; i++) {
            if (sortedNumbers.get(i) != sortedNumbers.get(i - 1) && sortedNumbers.get(i) != sortedNumbers.get(i + 1)) {
                return sortedNumbers.get(i);
            }
        }

        if (numbers.get(numbers.size() - 1) != numbers.get(numbers.size() - 2)) {
            return sortedNumbers.get(numbers.size() - 1);
        }
        throw new IllegalStateException("No unique number.");
    }

    private void addNumbers(String[] temp) {
        for (String s : temp) {
            numbers.add(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {
        NumberStat ns = new NumberStat();
        ns.readNumbers("numbers.txt");
        System.out.println(ns.getNumbers().toString());
        System.out.println(ns.findSmallestUnique());
    }
}
