package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNoteBook {

    private List<Student> noteBook= new ArrayList<>();

    public void add(Student student) {
        noteBook.add(student);
    }

    public List<Student> sortNoteBook() {
        List<Student> sorted = new ArrayList<>(noteBook);
        Collections.sort(sorted);

        return sorted;
    }
}
