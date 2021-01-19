package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

    public void readStatesFromFile(String stringFileName) {
        Path path = Path.of("src/main/resources/" + stringFileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split("-");
                states.add(new State(splittedLine[0], splittedLine[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!");
        }
    }

    public String findCapitalByStateName(String stateName) {
        String stateCapital = null;
        for (State s : states) {
            if (s.getStateName().equals(stateName)) {
                stateCapital = s.getCapital();
            }
        }
        if (stateCapital == null) {
            throw new IllegalArgumentException("No state with this name!");
        }
        return stateCapital;
    }
}