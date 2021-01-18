package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readGradesFromFile(String filename) {
        try {
            Path path = Path.of("src/main/resources/" + filename);
            BufferedReader br = Files.newBufferedReader(path);
            String line;
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(" ");
                String name = studentData[0];
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < studentData.length; i++) {
                    int grade = Integer.parseInt(studentData[i]);
                    grades.add(grade);
                }
                students.add (new Student(name, grades));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public double classAverage() {
        double average = 0.0;
        for (Student s : students) {
            average += s.average();
        }
        average /= students.size();
        return average;
    }
}
