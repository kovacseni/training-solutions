package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords;
    private List<Subject> subjectList;
    private List<Tutor> tutorList;
    private Scanner scanner = new Scanner(System.in);
    private int menuItem;
    private int menuClose;

    public SchoolRecordsController (ClassRecords classRecords, List<Subject> subjectList, List<Tutor> tutorList) {
        this.classRecords = classRecords;
        this.subjectList = subjectList;
        this.tutorList = tutorList;
    }

    public List<Subject> initSchool(String subjectName) {
        Subject subject = new Subject(subjectName);
        subjectList.add(subject);

        return subjectList;
    }

    public List<Tutor> initSchool(String name, List<Subject> taughtSubjects) {
        Tutor tutor = new Tutor(name, taughtSubjects);
        tutorList.add(tutor);

        return tutorList;
    }

    public void listMenu() {
        List<String> menu = new ArrayList<>();

        menu.add("1. Diákok nevének kilistázása");
        menu.add("2. Diák keresése név alapján");
        menu.add("3. Diák rögzítése a rendszerben");
        menu.add("4. Diák törlése név alapján");
        menu.add("5. Diák feleltetése");
        menu.add("6. Osztályátlag kiszámolása");
        menu.add("7. Tantárgyi átlag kiszámolása");
        menu.add("8. Diákok átlagának megjelenítése");
        menu.add("9. Diák átlagának kiírása");
        menu.add("10. Diák tantárgyhoz tartozó átlagának kiírása");
        menu.add("11. Kilépés");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

    public void runMenu() {
        System.out.println("Kérem, válasszon a megadott menüpontok közül:");
        menuItem = Integer.parseInt(scanner.nextLine());

        switch(menuItem) {
            case 1 :
                menu1();
                break;
            case 2 :
                menu2();
                break;
            case 3 :
                menu3();
                break;
            case 4 :
                menu4();
                break;
            case 5 :
                menu5();
                break;
            case 6 :
                menu6();
                break;
            case 7 :
                menu7();
                break;
            case 8 :
                menu8();
                break;
            case 9 :
                menu9();
                break;
            case 10 :
                menu10();
                break;
            case 11 :
                menuClose = 11;
                break;
            default :
                System.out.println("Ismeretlen menüpont!");
                System.out.println();
                break;
        }
    }

    private void menu1() {
        System.out.println("Az osztály tanulói: ");
        System.out.println(classRecords.listStudentNames());
        System.out.println();
    }

    private void menu2() {
        System.out.println("Adja meg a keresett diák nevét:");
        Student student = classRecords.findStudentByName(scanner.nextLine());
        System.out.println(student.toString());
        System.out.println();
    }

    private void menu3() {
        System.out.println("Adja meg a diák nevét, akit rögzíteni szeretne a rendszerben:");
        Student student = new Student(scanner.nextLine());
        classRecords.addStudent(student);
        System.out.println("A diák rögzítése megtörtént.");
        menu1();
    }

    private void menu4() {
        System.out.println("Adja meg a diák nevét, akit törölni szeretne a rendszerből:");
        Student student = classRecords.findStudentByName(scanner.nextLine());
        classRecords.removeStudent(student);
        System.out.println("A diák törlése megtörtént.");
        menu1();
    }

    private void menu5() {

        System.out.println("Melyik tantárgyból kíván feleltetni?");
        String str = scanner.nextLine();
        Subject repetitionSubject = null;
        for (Subject s : subjectList) {
            if (s.getSubjectName().equals(str)) {
                repetitionSubject = s;
            }
        }

        System.out.println("A mai felelő:");
        String st = classRecords.repetition().getName();
        System.out.println(st);
        Student repetitionStudent = classRecords.findStudentByName(st);

        System.out.println("A feleletre kapott jegy:");
        int i = Integer.parseInt(scanner.nextLine());
        MarkType repetitionGrade = null;
        for (MarkType m : MarkType.values()) {
            if (i == m.getValue()) {
                repetitionGrade = MarkType.values()[m.ordinal()];
            }
        }

        System.out.println("A feleltető tanár neve:");
        String s = scanner.nextLine();
        Tutor repetitionTutor = null;
        for (Tutor t : tutorList) {
            if (t.getName().equals(s)) {
                repetitionTutor = t;
            }
        }

        Mark repetitionMark = new Mark(repetitionGrade, repetitionSubject, repetitionTutor);
        repetitionStudent.grading(repetitionMark);

        System.out.println("A felelet rögzítése megtörtént.");
        System.out.println();
    }

    private void menu6() {
        System.out.println("Az osztály átlaga:");
        double av = classRecords.calculateClassAverage();
        String classAverage = averageWithTwoDecimals(av);
        System.out.println(classAverage);
        System.out.println();
    }

    private void menu7() {
        System.out.println("Adja meg, melyik tantárgy átlagát szeretné megjeleníteni:");
        String str = scanner.nextLine();
        Subject averageSubject = null;
        for (Subject s : subjectList) {
            if (s.getSubjectName().equals(str)) {
                averageSubject = s;
            }
        }
        double av = classRecords.calculateClassAverageBySubject(averageSubject);
        String subjectAverage = averageWithTwoDecimals(av);
        System.out.println("Az osztály átlaga " + str + " tantárgyból: " + subjectAverage);
        System.out.println();
    }

    private void menu8() {
        List<StudyResultByName> study = classRecords.listStudyResults();
        String studyResults = null;
        for (StudyResultByName s : study) {
            double av = s.getStudyAverage();
            String sr = averageWithTwoDecimals(av);
            studyResults = "A diák neve: " + s.getStudentName() + ", össztantárgyi átlaga: " + sr;
            System.out.println(studyResults);
        }
        System.out.println();
    }

    private void menu9() {
        System.out.println("Adja meg a keresett diák nevét:");
        Student student = classRecords.findStudentByName(scanner.nextLine());
        double av = student.calculateAverage();
        String studentAverage = averageWithTwoDecimals(av);
        System.out.println(student.getName() + " össztantárgyi átlaga: " + studentAverage);
        System.out.println();
    }

    private void menu10() {
        System.out.println("Adja meg a keresett diák nevét:");
        Student student = classRecords.findStudentByName(scanner.nextLine());
        System.out.println("Adja meg, melyik tantárgy átlagát szeretné megjeleníteni: ");
        Subject subject = new Subject(scanner.nextLine());

        double av = student.calculateSubjectAverage(subject);
        String studentAverage = averageWithTwoDecimals(av);
        System.out.println(student.getName() + " tantárgyi átlaga " + subject.getSubjectName() + " tantárgyból: " + studentAverage);
        System.out.println();
    }

    private String averageWithTwoDecimals(double average) {
        String av = Double.toString(average);
        if (av.length() < 4) {
            av = av + "0";
        }
        return av;
    }

    public static void main(String[] args) {
        List<Tutor> tutorList = new ArrayList<>();
        List<Subject> subjectList = new ArrayList<>();
        ClassRecords twelveA = new ClassRecords("12.A", new Random(5));
        SchoolRecordsController arpadGimnazium = new SchoolRecordsController(twelveA, subjectList, tutorList);

        arpadGimnazium.initSchool("matematika");
        arpadGimnazium.initSchool("magyar nyelv és irodalom");
        arpadGimnazium.initSchool("történelem");
        arpadGimnazium.initSchool("angol nyelv");
        arpadGimnazium.initSchool("német nyelv");
        arpadGimnazium.initSchool("földrajz");
        arpadGimnazium.initSchool("biológia");
        arpadGimnazium.initSchool("kémia");
        arpadGimnazium.initSchool("fizika");
        arpadGimnazium.initSchool("számítástechnika");
        arpadGimnazium.initSchool("ének");
        arpadGimnazium.initSchool("rajz");
        arpadGimnazium.initSchool("technika");
        arpadGimnazium.initSchool("testnevelés");

        arpadGimnazium.initSchool("Nagyné Kiss Ágnes", Arrays.asList(new Subject("biológia"), new Subject("földrajz")));
        arpadGimnazium.initSchool("Turi Tamás", Arrays.asList(new Subject("számítástechnika")));
        arpadGimnazium.initSchool("Kérész Csilla", Arrays.asList(new Subject("magyar nyelv és irodalom"), new Subject("történelem")));
        arpadGimnazium.initSchool("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")));
        arpadGimnazium.initSchool("Szabó Lajos", Arrays.asList(new Subject("testnevelés")));
        arpadGimnazium.initSchool("Mányi-Kovács Benedek", Arrays.asList(new Subject("technika"),new Subject("rajz")));
        arpadGimnazium.initSchool("Simonné Szép Zsófia", Arrays.asList(new Subject("angol nyelv"), new Subject("német nyelv")));
        arpadGimnazium.initSchool("Lévai Gyula", Arrays.asList(new Subject("fizika"), new Subject("ének")));

        Student firstStudent = new Student("Tódor László");
        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), new Tutor("Nagyné Kiss Ágnes", Arrays.asList(new Subject("biológia"), new Subject("földrajz")))));
        firstStudent.grading(new Mark(MarkType.A, new Subject("matematika"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        firstStudent.grading(new Mark(MarkType.A, new Subject("történelem"), new Tutor("Kérész Csilla", Arrays.asList(new Subject("magyar irodalom és nyelvtan"), new Subject("történelem")))));
        firstStudent.grading(new Mark(MarkType.A, new Subject("matematika"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        firstStudent.grading(new Mark(MarkType.B, new Subject("kémia"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        twelveA.addStudent(firstStudent);

        Student secondStudent = new Student("Kocsis Krisztina");
        secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), new Tutor("Nagyné Kiss Ágnes", Arrays.asList(new Subject("biológia"), new Subject("földrajz")))));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        secondStudent.grading(new Mark(MarkType.D, new Subject("ének"), new Tutor("Lévai Gyula", Arrays.asList(new Subject("fizika"), new Subject("ének")))));
        secondStudent.grading(new Mark(MarkType.B, new Subject("matematika"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        secondStudent.grading(new Mark(MarkType.C, new Subject("ének"), new Tutor("Lévai Gyula", Arrays.asList(new Subject("fizika"), new Subject("ének")))));
        twelveA.addStudent(secondStudent);

        Student thirdStudent = new Student("Gábor József");
        thirdStudent.grading(new Mark(MarkType.B, new Subject("rajz"), new Tutor("Mányi-Kovács Benedek", Arrays.asList(new Subject("technika"),new Subject("rajz")))));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("testnevelés"), new Tutor("Szabó Lajos", Arrays.asList(new Subject("testnevelés")))));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), new Tutor("Csortos Géza", Arrays.asList(new Subject("matematika"), new Subject("kémia")))));
        thirdStudent.grading(new Mark(MarkType.B, new Subject("földrajz"), new Tutor("Nagyné Kiss Ágnes", Arrays.asList(new Subject("biológia"), new Subject("földrajz")))));
        twelveA.addStudent(thirdStudent);

        Student fourthStudent = new Student("Véges Máté");
        fourthStudent.grading(new Mark(MarkType.A, new Subject("angol nyelv"), new Tutor("Simonné Szép Zsófia", Arrays.asList(new Subject("angol nyelv"), new Subject("német nyelv")))));
        fourthStudent.grading(new Mark(MarkType.B, new Subject("német nyelv"), new Tutor("Simonné Szép Zsófia", Arrays.asList(new Subject("angol nyelv"), new Subject("német nyelv")))));
        fourthStudent.grading(new Mark(MarkType.A, new Subject("angol nyelv"), new Tutor("Simonné Szép Zsófia", Arrays.asList(new Subject("angol nyelv"), new Subject("német nyelv")))));
        fourthStudent.grading(new Mark(MarkType.B, new Subject("számítástechnika"), new Tutor("Turi Tamás", Arrays.asList(new Subject("számítástechnika")))));
        fourthStudent.grading(new Mark(MarkType.B, new Subject("magyar nyelv és irodalom"), new Tutor("Kérész Csilla", Arrays.asList(new Subject("magyar nyelv és irodalom"), new Subject("történelem")))));
        twelveA.addStudent(fourthStudent);

        Student fifthStudent = new Student("Joó Rita");
        fifthStudent.grading(new Mark(MarkType.D, new Subject("magyar nyelv és irodalom"), new Tutor("Kérész Csilla", Arrays.asList(new Subject("magyar nyelv és irodalom"), new Subject("történelem")))));
        fifthStudent.grading(new Mark(MarkType.F, new Subject("technika"), new Tutor("Mányi-Kovács Benedek", Arrays.asList(new Subject("technika"),new Subject("rajz")))));
        fifthStudent.grading(new Mark(MarkType.D, new Subject("fizika"), new Tutor("Lévai Gyula", Arrays.asList(new Subject("fizika"), new Subject("ének")))));
        fifthStudent.grading(new Mark(MarkType.C, new Subject("magyar nyelv és irodalom"), new Tutor("Kérész Csilla", Arrays.asList(new Subject("magyar nyelv és irodalom"), new Subject("történelem")))));
        fifthStudent.grading(new Mark(MarkType.F, new Subject("német nyelv"), new Tutor("Simonné Szép Zsófia", Arrays.asList(new Subject("angol nyelv"), new Subject("német nyelv")))));
        twelveA.addStudent(fifthStudent);

        do {
            arpadGimnazium.listMenu();
            arpadGimnazium.runMenu();
        } while (arpadGimnazium.menuClose != 11);
    }
}
