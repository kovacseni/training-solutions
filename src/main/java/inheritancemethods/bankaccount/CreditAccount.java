package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long debit = amount + costOfTransaction(amount);
        if (debit > getBalance() + overdraftLimit) {
            return false;
        }
        if (debit <= getBalance()) {
            super.transaction(amount);
        } else {
            long credit = amount - getBalance();
            balanceToZero();
            overdraftLimit -= credit + costOfTransaction(amount);
        }
        return true;
    }
}
