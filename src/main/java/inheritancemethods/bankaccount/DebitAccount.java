package inheritancemethods.bankaccount;

public class DebitAccount {

    private String accountNumber;
    private long balance;
    private final double COST = 3.0;
    private final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount) {
        return (amount * COST / 100.0) <= MIN_COST ? MIN_COST : (long)(amount * COST / 100.0);
    }

    public boolean transaction(long amount) {
        boolean success = false;
        long debit = amount + costOfTransaction(amount);
        if (debit <= balance) {
            balance -= debit;
            success = true;
        }
        return success;
    }

    public void balanceToZero() {
        balance = 0;
    }
}
