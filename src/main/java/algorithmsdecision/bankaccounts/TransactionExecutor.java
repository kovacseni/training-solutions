package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction t : transactions) {
            for (BankAccount b : accounts) {
                if (b.getAccountNumber().equals(t.getAccountNumber())) {
                    execute(b, t);
                }
            }
        }
    }

    private void execute (BankAccount b, Transaction t) {
        if (t.isCredit()) {
            b.deposit(t.getAmount());
            t.successfulTransaction();
        } else if (t.isDebit()) {
            b.withdraw(t.getAmount());
            t.successfulTransaction();
        } else {
            t.unsuccessfulTransaction();
        }
    }
}
