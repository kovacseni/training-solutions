package classstructureintegrate;

public class Bank {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("10073217-12000098-67341590", "Tóth Kálmán", 103400);
        BankAccount account2 = new BankAccount("13775612-15436758-63563860", "Kiss Margit", 456789);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        int a = account1.deposit(23456);
        System.out.println(a);
        int b = account2.withdraw(67890);
        System.out.println(b);

        account1.transfer(account2, 100111);
    }
}
