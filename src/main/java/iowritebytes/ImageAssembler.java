package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] imageBytes, Path folder) {
        Path path = folder.resolve("image.png");
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (byte[] b : imageBytes) {
                bos.write(b);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }
}
