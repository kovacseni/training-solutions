package week14d03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {

    private String name;
    private Map<String, List<Integer>> notes;

    public Student(String name) {
        this.name = name;
        this.notes = new HashMap<>();
    }

    public void addNote(String subject, int note) {
        if(!notes.containsKey(subject)) {
            notes.put(subject, new ArrayList<>());
        }
        notes.get(subject).add(note);
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getNotes() {
        return new HashMap<>(notes);
    }

    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
