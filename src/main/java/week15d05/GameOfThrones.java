package week15d05;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrones {

    public String getFamilyWithMostBattles(Reader reader) {
        Map <String, Integer> familysInBattles = new HashMap<>();
        try (BufferedReader br = new BufferedReader(reader)) {
            String line = br.readLine();
            while((line = br.readLine()) != null) {
                List<String> familys = getFamilys(line);
                for (String s : familys) {
                    putToMap(s, familysInBattles);
                }
            }
            String familyWithMostBattles = getFamily(familysInBattles);
            return familyWithMostBattles;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private List<String> getFamilys(String line) {
        String[] temp = line.split(",");
        List<String> familys = Arrays.asList(temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12]);
        return familys;
    }

    private void putToMap(String s, Map<String, Integer> familysInBattles) {
        if (!s.isEmpty() && !familysInBattles.containsKey(s)) {
            familysInBattles.put(s, 0);
        } else if (!s.isEmpty()) {
            familysInBattles.put(s, familysInBattles.get(s) + 1);
        }
    }

    private String getFamily(Map<String, Integer> familysInBattles) {
        int max = 0;
        String family = null;
        for (String s : familysInBattles.keySet()) {
            if (familysInBattles.get(s) > max) {
                max = familysInBattles.get(s);
                family = s;
            }
        }
        return family;
    }
}
