package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;
import exceptionclass.bank.InvalidBankOperationException;

public class Account {

    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null || "".equals(accountNumber) || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid Accountnumber");
        }
        if (balance < 0) {
            throw new LowBalanceBankOperationException();
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) {
            throw new InvalidAmountBankOperationException();
        }
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) {
        if (amount < 0) {
            throw new InvalidAmountBankOperationException();
        }
        if (amount > balance) {
            throw new LowBalanceBankOperationException();
        }
        balance = balance - amount;
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            throw new InvalidAmountBankOperationException();
        }
        balance = balance + amount;
        return balance;
    }
}
