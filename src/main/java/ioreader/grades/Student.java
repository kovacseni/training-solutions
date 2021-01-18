package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(grades);
    }

    public double average() {
        double sum = 0.0;
        for (Integer i : grades) {
            sum += i;
        }
        sum /= grades.size();
        return sum;
    }

    public boolean isIncreasing() {
        boolean increasing = true;
        for (int i = 0; i < (grades.size() - 1); i++) {
            if (grades.get(i + 1) < grades.get(i)) {
                increasing = false;
            }
        }
        return increasing;
    }
}
