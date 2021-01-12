package exceptionclass.bank2;

import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Invalid Accountlist");
        }
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void payment(String accountNumber, double amount) throws exceptionclass.bank.InvalidBankOperationException {
        Account account = get(accountNumber);
        account.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) throws exceptionclass.bank.InvalidBankOperationException {
        Account account = get(accountNumber);
        account.deposit(amount);
    }

    private Account get(String accountNumber) throws exceptionclass.bank.InvalidBankOperationException {
        for (Account a: accounts) {
            if (accountNumber.equals(a.getAccountNumber())) {
                return a;
            }
        }
        throw new InvalidAccountNumberBankOperationException();
    }
}
