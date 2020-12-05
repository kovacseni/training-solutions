package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private static final List<Rate> ACTUAL_RATES;
    private long balance;
    private Currency currency;

    static{
        ACTUAL_RATES = new ArrayList<>();
        ACTUAL_RATES.add(new Rate(Currency.HUF, 1.0));
        ACTUAL_RATES.add(new Rate(Currency.EUR, 308.23));
        ACTUAL_RATES.add(new Rate(Currency.SFR, 289.24));
        ACTUAL_RATES.add(new Rate(Currency.GBP, 362.23));
        ACTUAL_RATES.add(new Rate(Currency.USD, 289.77));
    }

    public CreditCard(long balance, Currency currency) {
        double convertedBalance = 0.0;
        for (Rate r : ACTUAL_RATES) {
            if (currency == r.getCurrency()) {
                convertedBalance = Math.round(balance * r.getConversionFaktor());
            }
        }
        this.balance = (long)convertedBalance;
        this.currency = Currency.HUF;
    }

    public CreditCard(long balance) {
        this.balance = balance;
        this.currency = Currency.HUF;
    }

    public CreditCard(long balance, Currency currency, List<Rate> ACTUAL_RATES) {
        this(balance, currency);
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        double convertedAmount = 0.0;
        for (Rate r : ACTUAL_RATES) {
            if (currency == r.getCurrency()) {
                convertedAmount = Math.round((amount * r.getConversionFaktor()));
            }
        }
        if (balance > (long)convertedAmount) {
            this.balance = balance - (long) convertedAmount;
            return true;
        } else {
            return false;
        }
    }

    public boolean payment(long amount) {
        if (balance > amount) {
            this.balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }
}
