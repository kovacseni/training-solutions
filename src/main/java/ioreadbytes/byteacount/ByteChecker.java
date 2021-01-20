package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String filename) {
        Path path = Path.of(filename);
        int sumA = 0;
            try (InputStream is = Files.newInputStream(path)) {
                byte[] characters = is.readAllBytes();
                for (byte b : characters) {
                    if (Byte.toString(b).toLowerCase().equals("a")) {
                        sumA++;
                    }
                }
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file.", ioe);
            }
        return sumA;
    }
}
