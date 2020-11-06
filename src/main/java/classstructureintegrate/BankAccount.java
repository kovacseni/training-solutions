package classstructureintegrate;

public class BankAccount {

    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this. balance = balance;
    }

    public int deposit(int amount) {
        return balance + amount;
    }

    public int withdraw(int amount) {
        return balance - amount;
    }

    public String getInfo() {
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }

    public int transfer(BankAccount to, int amount){
        System.out.println(withdraw(amount));
        System.out.println(to.deposit(amount));
    return 1;
    }
}
