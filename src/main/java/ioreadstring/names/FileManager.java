package ioreadstring.names;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<Human> humans = new ArrayList<>();
    private Path path;

    public FileManager(String pathString) {
        this.path = Path.of(pathString);
    }

    public List<Human> getHumans() {
        return humans;
    }

    public Path getMyFile() {
        return path;
    }

    public void readFromFile() {
        try {
            List<String> names = Files.readAllLines(path);
            for (String s : names) {
                String[] namesArray = s.split(" ");
                String firstName = namesArray[0];
                String lastName = namesArray[1];
                humans.add(new Human(firstName, lastName));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
