package week07d05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SaveInput {

    public void save(String line1, String line2, String line3, String filename) {
        Path path = Path.of("src/main/resources/" + filename);
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write(line1 + "\n");
            bw.write(line2 + "\n");
            bw.write(line3);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem, írja be egymás után 3 sorban, amit el szeretne menteni a fájlba!");
        System.out.println("1. sor:");
        String line1 = scanner.nextLine();
        System.out.println("2. sor:");
        String line2 = scanner.nextLine();
        System.out.println("3. sor:");
        String line3 = scanner.nextLine();
        System.out.println("Végül kérem, adja meg a fájlnevet, amibe menteni szeretne:");
        String filename = scanner.nextLine();

        new SaveInput().save(line1, line2, line3, filename);
    }

}
