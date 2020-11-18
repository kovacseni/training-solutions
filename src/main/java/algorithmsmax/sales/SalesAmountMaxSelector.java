package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersonList) {
        Salesperson max = null;
        for (Salesperson s : salespersonList) {
            if (max == null || s.getAmount() > max.getAmount()) {
                max = s;
            }
        }
        return max;
    }
}
