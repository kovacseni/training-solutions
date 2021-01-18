package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        try {
            Path path = Path.of(pathString);
            byte[] temperatures = Files.readAllBytes(path);
            return new Temperatures(temperatures);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
