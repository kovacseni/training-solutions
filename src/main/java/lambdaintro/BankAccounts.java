package lambdaintro;

import java.text.Collator;
import java.util.*;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> sortedAccounts = new ArrayList<>(bankAccounts);
        sortedAccounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return sortedAccounts;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> sortedAccounts = new ArrayList<>(bankAccounts);
        sortedAccounts.sort(Comparator.comparing((account) -> Math.abs(account.getBalance())));
        return sortedAccounts;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> sortedAccounts = new ArrayList<>(bankAccounts);
        sortedAccounts.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return sortedAccounts;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> sortedAccounts = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        sortedAccounts.sort( Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator)).thenComparing(BankAccount::getAccountNumber));
        return sortedAccounts;
    }
}
