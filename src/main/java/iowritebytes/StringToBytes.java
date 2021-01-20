package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> stringList, Path path) {
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (String s : stringList) {
                if (!s.startsWith("_")) {
                    os.write(s.getBytes());
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }
}
