package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream().mapToInt(Product::getPieces).sum();
    }

    public double getAveragePrice() {
        double av = 0.0;
        OptionalDouble average = products.stream().mapToDouble(Product::getPrice).average();
        if (average.isPresent()) {
            av = average.getAsDouble();
        }
         return av;
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stats = products.stream().filter(p -> p.getPrice() > minPrice).mapToInt(p -> p.getPieces()).summaryStatistics();
        StringBuilder sb = new StringBuilder();
        if (stats.getCount() == 0) {
            sb.append("Nincs ilyen termék.");
        } else {
            sb.append("Összesen ").append(stats.getCount()).append(" féle termék, amelyekből minimum ").append(stats.getMin()).append(" db, maximum ").append(stats.getMax()).append(" db, összesen ").append(stats.getSum()).append(" db van.");
        }

        return sb.toString();
    }
}
