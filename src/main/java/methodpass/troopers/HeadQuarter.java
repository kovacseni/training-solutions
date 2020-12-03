package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("Trooper must not be empty!");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (target == null || name == null || "".equals(name) || name.isBlank()) {
            throw new IllegalArgumentException("Name and target must not be empty!");
        }

        Trooper trooper = findTrooperByName(name);
        moveTrooper(trooper, target);
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target must not be empty!");
        }

        Trooper trooper = findClosestTrooper(target);
        moveTrooper(trooper, target);
    }

    private Trooper findTrooperByName(String name) {
        Trooper trooper = null;
        for (Trooper t : troopers) {
            if (t.getName().equals(name)) {
                trooper = t;
            }
        }
        return trooper;
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper trooper = troopers.get(0);
        for (Trooper t : troopers) {
            if (t.distanceFrom(target) < trooper.distanceFrom(target)) {
                trooper = t;
            }
        }
        return trooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }
}
