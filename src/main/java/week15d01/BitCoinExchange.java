package week15d01;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BitCoinExchange {

    public BitCoin getBest(List<Integer> rates) {
        Optional<Integer> purchase = rates.stream().min(Comparator.comparing(Integer::intValue));
        int purchaseDay = rates.indexOf(purchase.get());

        Optional<Integer> sale = rates.stream().max(Comparator.comparing(Integer::intValue));
        int saleDay = rates.indexOf(sale.get());

        return new BitCoin(purchaseDay, saleDay);
    }
}
