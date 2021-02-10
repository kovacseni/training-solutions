package week15d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    Quiz quiz = new Quiz();
    @BeforeEach
    void setUp() {
        quiz.readFile("kerdesek.txt");
    }

    @Test
    void readFile() {
        assertEquals(57,quiz.getQuestions().size());
    }

    @Test
    void questionsByCategory() {
        List<String> result = quiz.questionsByCategory("matematika");
        assertEquals(21,result.size());
    }

    @Test
    void randomQuestion() {
        String randomQuestion = "Hany lakosa volt Magyarorszag legkisebb telepulesenek, Iborfianak, 2012 januar 1-en? 9 3 foldrajz";
        assertEquals(randomQuestion,quiz.randomQuestion(new Random(5)).toString());
    }

    @Test
    void allQuestionsByCategory() {
        Map<String, List<Question>> result = quiz.allQuestionsByCategory();
        assertEquals(21,result.get("matematika").size());
        assertEquals(5,result.keySet().size());
    }

    @Test
    void categoryWithMostPoints() {
        assertEquals("matematika", quiz.categoryWithMostPoints());
    }
}
