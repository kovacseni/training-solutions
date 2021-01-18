package week12d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeRounderTest {

    private int[] grades;

    @BeforeEach
    public void setUp() {
        grades = new int[101];
        for (int i = 0; i < 101; i++) {
            grades[i] = i;
        }
    }

    @Test
    public void testGradeRounder() {
        int[] gradesRounded = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 45, 45, 45, 46, 47, 50, 50, 50, 51, 52, 55, 55, 55, 56, 57, 60, 60, 60, 61, 62, 65, 65, 65, 66, 67, 70, 70, 70, 71, 72, 75, 75, 75, 76, 77, 80, 80, 80, 81, 82, 85, 85, 85, 86, 87, 90, 90, 90, 91, 92, 95, 95, 95, 96, 97, 100, 100, 100};
        Assertions.assertArrayEquals(gradesRounded, new GradeRounder().roundGrades(grades));
    }
}
