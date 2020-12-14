package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {
    private boolean[] prison = new boolean[100];

    public Sultan() {
        for (int i = 0; i < 100; i++) {
            prison[i] = false;
        }
    }

    public List<Integer> openDoors() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < prison.length; j++) {
                if ((j+1) % (i+1) == 0) {
                    if (prison[j] == true) {
                        prison[j] = false;
                    } else {
                        prison[j] = true;
                    }
                }

            }
        }

        List<Integer> openList = new ArrayList<>();
        for (int i = 0; i < prison.length; i++) {
            if (prison[i] == true) {
                openList.add(i+1);
            }
        }
        return openList;
    }

    // A feladat bónusz megoldása: tetszőleges számú nap esetén
    // visszaadja az éppen aktuálisan nyitva lévő cellák számát.

    public List<Integer> openDoorsBonus(int numberOfDays) {
        for (int i = 0; i < numberOfDays; i++) {
            for (int j = 0; j < prison.length; j++) {
                if ((j + 1) % (i + 1) == 0) {
                    if (prison[j] == true) {
                        prison[j] = false;
                    } else {
                        prison[j] = true;
                    }
                }
            }
        }

        List<Integer> openList = new ArrayList<>();
        for (int i = 0; i < prison.length; i++) {
            if (prison[i] == true) {
                openList.add(i+1);
            }
        }
        return openList;
    }
}