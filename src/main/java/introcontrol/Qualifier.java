package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adj meg egy számot!");
        double szam = scanner.nextDouble();

        if (szam > 100) {
            System.out.println("nagyobb, mint száz");
        } else {
            System.out.println("száz, vagy kisebb");
        }

    }
}

