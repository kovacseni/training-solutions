package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Register {

    public void newMark(Path nameFile, int mark) {
        try {
            if (Files.exists(nameFile)) {
                Files.writeString(nameFile, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(nameFile, Integer.toString(mark));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    public void average(Path path) {
        try {
            List<String> marks = Files.readAllLines(path);
            List<Integer> intMarks = new ArrayList<>();
            for (String s : marks) {
                int mark = Integer.parseInt(s);
                intMarks.add(mark);
            }
            double sum = 0.0;
            for (Integer i : intMarks) {
                sum += i;
            }
            sum /= intMarks.size();
            String average = Double.toString(sum);
            Files.writeString(path, "average: " + average, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read or write file.", ioe);
        }
    }
}
