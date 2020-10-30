package classstructureio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Adj meg egy egész számot!");
        Scanner scanner = new Scanner(System.in);
        int egyikSzam = scanner.nextInt();

        System.out.println("Adj meg egy másik egész számot!");
        int masikSzam = scanner.nextInt();

        System.out.println(egyikSzam + "+" + masikSzam);

        System.out.println(egyikSzam + masikSzam);

    }

}
