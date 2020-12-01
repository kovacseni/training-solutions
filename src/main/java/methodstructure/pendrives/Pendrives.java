package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendriveList){
        Pendrive bestPendrive = pendriveList.get(0);
        for (Pendrive p : pendriveList) {
            if (p.comparePricePerCapacity(bestPendrive) == -1) {
                bestPendrive = p;
            }
        }
        return bestPendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendriveList) {
        Pendrive cheapestPendrive = pendriveList.get(0);
        for (Pendrive p : pendriveList) {
            if (p.cheaperThan(cheapestPendrive)) {
                cheapestPendrive = p;
            }
        }
        return cheapestPendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive p : pendriveList) {
            if (p.getCapacity() == capacity) {
                p.risePrice(percent);
            }
        }
    }
}
