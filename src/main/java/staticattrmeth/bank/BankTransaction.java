package staticattrmeth.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTransaction {

    private static long currentMinValue = 10000000;
    private static long currentMaxValue = 1;
    private static final long MIN_LIMIT = 1;
    private static final long MAX_LIMIT = 10000000;
    private static long numberOfTransactions = 0;
    private static BigDecimal sumOfTransactions = new BigDecimal("0");
    private long trxValue;

    public BankTransaction(long trxValue) {
        if (trxValue <= MIN_LIMIT || trxValue >= MAX_LIMIT) {
            throw new IllegalArgumentException("Ez a tranzakció nem hajtható végre.");
        }
        numberOfTransactions++;
        sumOfTransactions = sumOfTransactions.add(new BigDecimal(Long.toString(trxValue)));
        if (trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }
        if (trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }

        this.trxValue = trxValue;
    }

    public static void initTheDay() {
        numberOfTransactions = 0;
        currentMinValue = 10000000;
        currentMaxValue = 1;
        sumOfTransactions = new BigDecimal("0");
    }

    public static BigDecimal averageOfTransaction() {
        return numberOfTransactions == 0 ? new BigDecimal("0") : sumOfTransactions.divide(new BigDecimal(Long.toString(numberOfTransactions)), 0, RoundingMode.HALF_UP);
    }

    public static long getCurrentMinValue() {
        return numberOfTransactions == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return numberOfTransactions == 0 ? 0 : currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTransactions;
    }

    public long getTrxValue() {
        return trxValue;
    }

}
