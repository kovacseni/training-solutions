package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumbers() {
        int sum = 0;
        try {
            for (int i = 0; i <= 99; i++) {
                String fileName;
                if (i <= 9) {
                    fileName = "number" + 0 + i + ".txt";
                } else {
                    fileName = "number" + i + ".txt";
                }
                Path path = Path.of("src/main/resources/filessum/" + fileName);
                if (Files.isRegularFile(path)) {
                    String number = Files.readString(path);
                    sum += Integer.parseInt(number);
                }
            }
            } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return sum;
    }

    public static void main(String[] args) {
        FilesSum f = new FilesSum();
        System.out.println(f.sumNumbers());
    }
}
