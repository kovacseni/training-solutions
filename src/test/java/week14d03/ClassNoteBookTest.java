package week14d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassNoteBookTest {

    private ClassNoteBook cnb = new ClassNoteBook();

    @BeforeEach
    public void setUp() {
        Student student1 = new Student("Kiss József");
        Student student2 = new Student("Nagy Károly");
        Student student3 = new Student("Szép Margit");
        Student student4 = new Student("Joó Renátó");
        Student student5 = new Student("Földi Irén");

        student1.addNote("matematika", 2);
        student1.addNote("földrajz", 3);
        student1.addNote("matematika", 4);
        student1.addNote("német", 5);
        student1.addNote("német", 1);

        student2.addNote("biológia", 3);
        student2.addNote("földrajz", 4);
        student2.addNote("biológia", 4);
        student2.addNote("angol", 3);
        student2.addNote("kémia", 1);

        student3.addNote("kémia", 4);
        student3.addNote("fizika", 3);
        student3.addNote("kémia", 4);
        student3.addNote("fizika", 4);
        student3.addNote("kémia", 2);

        student4.addNote("ének", 4);
        student4.addNote("matematika", 5);
        student4.addNote("rajz", 5);
        student4.addNote("matematika", 4);
        student4.addNote("testnevelés", 5);

        student5.addNote("testnevelés", 2);
        student5.addNote("biológia", 3);
        student5.addNote("matematika", 2);
        student5.addNote("testnevelés", 1);
        student5.addNote("biológia", 1);

        cnb.add(student1);
        cnb.add(student2);
        cnb.add(student3);
        cnb.add(student4);
        cnb.add(student5);
    }

    @Test
    public void testSortNoteBook() {
        Assertions.assertEquals("Nagy Károly", cnb.sortNoteBook().get(3).getName());
        Assertions.assertEquals(4, cnb.sortNoteBook().get(1).getNotes().get("matematika").get(1));
    }
}
