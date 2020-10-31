package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a termék nevét:");
        String name = scanner.nextLine();

        System.out.println("Adja meg az árát:");
        int price = scanner.nextInt();

        Product termek = new Product(name, price);
        System.out.println("A termék adatai: " + termek.getName() + ", " + termek.getPrice() + " Ft");

        termek.increasePrice(200);
        System.out.println("A gazdasági válság miatt sajnos egy kicsit emelnünk kellett árainkon.");
        System.out.println("A termék adatai: " + termek.getName() + ", " + termek.getPrice() + " Ft");

        termek.decreasePrice(220);
        System.out.println("Akcióóó!!!");
        System.out.println("A termék adatai: " + termek.getName() + ", " + termek.getPrice() + " Ft");


    }
}
