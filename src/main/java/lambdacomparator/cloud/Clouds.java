package lambdacomparator.cloud;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorages) {
        cloudStorages.sort(Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
        return cloudStorages.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorages) {
        return Collections.min(cloudStorages, Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))).thenComparingDouble(CloudStorage::getPrice));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorages) {
        List<CloudStorage> threeWorst = cloudStorages.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        return threeWorst;
    }
}
