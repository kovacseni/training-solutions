package kepesitovizsgagyakorlas.exylaci.kviz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {

    private final int id;
    private final String question;
    private List<String> answers;

    public Question(int id, String question, String... answers) {
        this.id = id;
        this.question = question;
        this.answers = Arrays.asList(answers);
        Collections.shuffle(this.answers);
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return id +
                ". " + question + "\n" +
                answers.get(0) + "\n" +
                answers.get(1) + "\n" +
                answers.get(2) + "\n" +
                answers.get(3);
    }
}
