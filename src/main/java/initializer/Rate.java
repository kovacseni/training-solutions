package initializer;

public class Rate {

    private Currency currency;
    private double conversionFaktor;

    public Rate(Currency currency, double conversionFaktor){
        this.currency = currency;
        this.conversionFaktor = conversionFaktor;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getConversionFaktor() {
        return conversionFaktor;
    }
}
