package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactionsList) {

        int sumTransactions = 0;
        for (Transaction t : transactionsList) {
            if (t.isCredit()) {
                sumTransactions = sumTransactions + t.getAmount();
            }
        }
        return sumTransactions;
    }
}
