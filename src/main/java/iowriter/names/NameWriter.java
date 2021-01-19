package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NameWriter {

    private Path path;
    private List<String> names = new ArrayList<>();

    public NameWriter(Path path) {
        this.path = path;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            names.add(name);
            for (String s : names) {
                bw.write(s);
                bw.write("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }
}
