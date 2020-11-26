package week05d04;

public class ProductSenior {

    private long price;
    private String currency;

    public ProductSenior(long price, Currency currency) {
        this.price = price;
        this.currency = currency.getName();
    }

    public double convertPrice(Currency otherCurrency) {
        double otherPrice = (double) price;
        if (otherCurrency == Currency.USD) {
            otherPrice = otherPrice / 300;
        }
        if (otherCurrency == Currency.HUF) {
            otherPrice = otherPrice * 300;
        }
        return otherPrice;
    }

    public static void main(String[] args) {
        ProductSenior p1 = new ProductSenior(600, Currency.HUF);
        ProductSenior p2 = new ProductSenior(6, Currency.USD);

        System.out.println(p1.convertPrice(Currency.USD));
        System.out.println(p2.convertPrice(Currency.HUF));
    }
}
