package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankaccounts, int minLimit) {

        int countAccounts = 0;
        for (BankAccount b : bankaccounts) {
            if (b.getBalance() > minLimit) {
                countAccounts = countAccounts + 1;
            }
        }
        return countAccounts;
    }
}
