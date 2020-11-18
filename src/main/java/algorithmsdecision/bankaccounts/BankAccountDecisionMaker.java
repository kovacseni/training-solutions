package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> accountList, int limit) {
        boolean contains = false;
        for (BankAccount b : accountList) {
            if (b.getBalance() > limit) {
                contains = true;
            }
        }
        return contains;
    }
}
