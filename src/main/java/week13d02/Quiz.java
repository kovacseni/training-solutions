package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private Map<String, List<Character>> answers = new HashMap<>();
    private char[] goodAnswers;

    public void loadFromFile(BufferedReader br) {
        try {
            String line = br.readLine();
            goodAnswers = line.toCharArray();
            while ((line = br.readLine()) != null) {
                putToMap(line);
            }
            br.close();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not handle file.", ioe);
        }
    }

    private void putToMap(String line) {
        String[] temp = line.split(" ");
        String id = temp[0];
        char answer = temp[1].charAt(0);
        if (!answers.containsKey(id)) {
            answers.put(id, new ArrayList<>());
        }
        answers.get(id).add(answer);
    }

    public boolean wasItAGoodAnswer(String id, int i) {
        if (i < 1 || i > 5) {
            throw new IllegalArgumentException("There was five questions in the quiz. Add a number between 1 and 5!");
        }
        if (!answers.containsKey(id)) {
            throw new IllegalArgumentException("This competitioner didn't took part in the quiz.");
        }
        char answer = answers.get(id).get(i - 1);

        return answer == goodAnswers[i - 1];
    }

    public String whichCompetitionerHasMostXes() {
        String id = null;
        int max = 0;
        for (String s : answers.keySet()) {
            int counter = countXes(answers.get(s));
            if (counter > max) {
                max = counter;
                id = s;
            }
        }
        return id;
    }

    private int countXes(List<Character> listOfAnswersById) {
        int counter = 0;
        for (char c : listOfAnswersById) {
            if (c == 'X') {
                counter++;
            }
        }
        return counter;
    }

    public String whichCompetitionerHasMostPoints() {
        String id = null;
        int max = 0;
        for (String s : answers.keySet()) {
            int counter = countPoints(answers.get(s));
            if (counter > max) {
                max = counter;
                id = s;
            }
        }
        return id;
    }

    private int countPoints(List<Character> listOfAnswersById) {
        int counter = 0;
        for (int i = 1; i <= listOfAnswersById.size(); i++) {
            if (listOfAnswersById.get(i - 1) == goodAnswers[i - 1]) {
                counter += i;
            }
        }
        return counter;
    }
}
