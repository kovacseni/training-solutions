package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersonList) {

        Salesperson bestSalesperson = null;
        for (Salesperson s : salespersonList) {
            if (bestSalesperson == null || (s.getDifferenceFromTarget() > 0 && s.getDifferenceFromTarget() > bestSalesperson.getDifferenceFromTarget())) {
                bestSalesperson = s;
            }
        }
        return bestSalesperson;
    }
}
