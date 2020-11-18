package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersonList) {
        Salesperson worstSalesperson = null;
        for (Salesperson s : salespersonList) {
            if (worstSalesperson == null || (s.getDifferenceFromTarget() < 0 && s.getDifferenceFromTarget() < worstSalesperson.getDifferenceFromTarget())) {
                worstSalesperson = s;
            }
        }
        return worstSalesperson;
    }
}
