package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void readTalents(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                productions.add(new Production(Integer.parseInt(splittedLine[0]), splittedLine[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public void calculateVotes(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line);
                increaseVoteNumber(id);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public void writeResultToFile(Path path) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path))) {
            for (Vote v : votes) {
                for (Production p : productions) {
                    if (v.getId() == p.getId()) {
                        pw.print(p.getId() + " " + p.getName() + " " + v.getNumber() + "\n");
                    }
                }
            }
            pw.print("Winner: " + whoIsTheWinner().getName());
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    private void increaseVoteNumber(int id) {
        boolean isInList = false;
        for (Vote v : votes) {
            if (id == v.getId()) {
                isInList = true;
                v.incNum();
            }
        }
        if (isInList == false) {
            votes.add(new Vote(id, 1));
        }
    }

    private Production whoIsTheWinner() {
        int max = votes.get(0).getNumber();
        int maxId = votes.get(0).getId();
        for (Vote v : votes) {
            if (v.getNumber() > max){
                max = v.getNumber();
                maxId = v.getId();
            }
        }
        Production production = null;
        for (Production p : productions) {
            if (maxId == p.getId()) {
                production = p;
            }
        }
        return production;
    }
}
