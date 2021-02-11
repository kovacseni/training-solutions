package week13d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class QuizTest {

    private Quiz quiz = new Quiz();

    @BeforeEach
    public void setUp() throws IOException {
        InputStream is = QuizTest.class.getResourceAsStream("/results.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        quiz.loadFromFile(br);
    }

    @Test
    public void testWasItAGoodAnswer() {
        Assertions.assertTrue(quiz.wasItAGoodAnswer("BD452", 4));
        Assertions.assertFalse(quiz.wasItAGoodAnswer("AB123", 2));
    }

    @Test
    public void testWhichCompetitionerHasMostXes() {
        Assertions.assertEquals("BD452", quiz.whichCompetitionerHasMostXes());
    }

    @Test
    public void testWhichCompetitionerHasMostPoints() {
        Assertions.assertEquals("GH1234", quiz.whichCompetitionerHasMostPoints());
    }
}
