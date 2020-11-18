package algorithmssum.sales;

import java.util.List;

public class SalesAmountSumCalculator {

    public int sumSalesAmount(List<Salesperson> salespersons) {
        int sumSales = 0;
        for (Salesperson s : salespersons) {
            sumSales = sumSales + s.getAmount();
        }
        return sumSales;
    }
}
