package finalmodifier;

import java.util.Scanner;

public class TaxCalculator {

    public static final double AFA = 27;

    double tax(double price) {
        return (price / 100 * AFA);
    }

    double priceWithTax(double price) {
        return (price / 100 * (100 + AFA));
    }

    public static void main(String[] args) {

        TaxCalculator taxCalculator = new TaxCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a termék nettó árát:");
        double price = scanner.nextInt();
        scanner.nextLine();

        System.out.println("A termék ÁFÁ-ja: " + taxCalculator.tax(price) + " Ft.");
        System.out.println("A termék bruttó ára: " + taxCalculator.priceWithTax(price) + " Ft.");

    }
}
