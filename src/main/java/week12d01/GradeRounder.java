package week12d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > 40 && grades[i] < 99) {
                int a = grades[i + 1];
                int b = grades[i + 2];
                if (a % 5 == 0) {
                    grades[i] = a;
                } else if (b % 5 == 0) {
                    grades[i] = b;
                }
            }
        }
        grades[99] = 100;
        return grades;
    }
}
