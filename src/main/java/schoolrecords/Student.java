package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {

        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }

        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        double sum = 0.0;
        for (Mark m : marks) {
                sum = sum + m.getMarkType().getValue();
            }
            double average = sum / marks.size();


        if (marks.size() == 0) {
            return sum;
        } else {
            String s = Double.toString(average) + "0";
            s = s.substring(0, 4);
            average = Double.parseDouble(s);
           return average;
        }
    }

    public double calculateSubjectAverage(Subject subject) {

        List<Mark> subjectMarks = new ArrayList<>();
        for (Mark m : marks) {
            if (m.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                subjectMarks.add(m);
            }
        }

        double sum = 0.0;
        for (Mark m : subjectMarks) {
            sum = sum + m.getMarkType().getValue();
        }
        double average = sum / subjectMarks.size();


        if (subjectMarks.size() == 0) {
            return sum;
        } else {
            String s = Double.toString(average) + "0";
            s = s.substring(0, 4);
            average = Double.parseDouble(s);
            return average;
        }
    }

    @Override
    public String toString() {
        String studentString = name;
        for (Mark m : marks) {
           studentString = studentString + " marks: " + m.getSubject().getSubjectName() + ": " + m.toString();
        }
        return studentString;
    }

    private boolean isEmpty(String str) {
        return str == null || str.equals("") || str.isBlank();
    }
}
