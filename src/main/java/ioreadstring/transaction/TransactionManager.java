package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String pathString) {
        Path path = Path.of(pathString);
        try {
            List<String> accounts = Files.readAllLines(path);
            for (String s : accounts) {
                String[] account = s.split(";");
                accountList.add(new BankAccount(account[0], account[1], Integer.parseInt(account[2])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void makeTransactions(String pathString) {
        Path path = Path.of(pathString);
        try {
            List<String> transactions = Files.readAllLines(path);
            for (String s : transactions) {
                String[] transaction = s.split(";");
                int amount = Integer.parseInt(transaction[1]);
                for (int i = 0; i < accountList.size(); i++) {
                    if (transaction[0].equals(accountList.get(i).getAccountNumber())) {
                        accountList.get(i).setBalance(amount);
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
