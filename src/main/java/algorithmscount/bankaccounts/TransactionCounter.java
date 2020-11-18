package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactionsList, int limit) {

        int countTransactions = 0;
        for (Transaction t : transactionsList) {
            if (t.getAmount() < limit) {
                countTransactions = countTransactions + 1;
            }
        }
        return countTransactions;
    }
}
