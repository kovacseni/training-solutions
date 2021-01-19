package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private List<Site> soldSites = new ArrayList<>();

    public void sellSite(Site site) {
        soldSites.add(site);
    }

    public int numberOfLastSoldSite() {
        Site lastSold = soldSites.get(soldSites.size() - 1);
        int houseNumber = 0;
        if (lastSold.getOddEven() == 1) {
            houseNumber = -1;
        }
        for (Site s : soldSites) {
            if (s.getOddEven() == lastSold.getOddEven()) {
                houseNumber += 2;
            }
        }
        return houseNumber;
    }

     public List<FenceStat> countStatistics() {
        List<FenceStat> statistics = new ArrayList<>();
        int sum = 0;
        for (Fence f : Fence.values()) {
            for (Site s : soldSites) {
                if (s.getFenceType() == f) {
                    sum++;
                }
            }
            statistics.add(new FenceStat(f, sum));
            sum = 0;
        }
        return statistics;
     }
}
