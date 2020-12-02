package methodoverloading.pub;

import java.util.List;
import methodoverloading.Time;

public class ListOfGoodPubs {

    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
    if (goodPubs == null || goodPubs.size() == 0) {
        throw new IllegalArgumentException("Pub list is empty!");
    }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub best = goodPubs.get(0);
        for (Pub p : goodPubs) {
            if (p.getOpenFrom().isEarlier(best.getOpenFrom())) {
                best = p;
            }
        }
        return best;
    }
}
