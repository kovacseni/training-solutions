package week12d04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SecretMessage {

    public void readSecretMessage(String file) {
        Path path = Path.of(file);
        try (InputStream is = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[10000];
            int size = is.read(bytes);
            for (int i = 0; i < size; i++) {
                int x = bytes[i];
                x += 10;
                char ch = (char)x;
                System.out.print(ch);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public static void main(String[] args) {
        SecretMessage sm = new SecretMessage();
        sm.readSecretMessage("src/main/resources/secret.dat");
    }
}
