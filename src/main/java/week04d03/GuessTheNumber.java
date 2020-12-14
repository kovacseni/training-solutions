package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int r = random.nextInt(100) + 1;
        System.out.println("Gondoltam egy számra 1 és 100 között. Találja ki a számot!");
        int a = scanner.nextInt();

        while (a != r) {
            if (a > r) {
                System.out.println("Ez a szám nagyobb, mint a gondolt szám.");
                System.out.println("Adjon meg egy másik számot!");
                a = scanner.nextInt();
            } else if (a < r) {
                System.out.println("Ez a szám kisebb, mint a gondolt szám.");
                System.out.println("Adjon meg egy másik számot!");
                a = scanner.nextInt();
            }
        }

        if (a == r) {
        System.out.println("Igen, erre a számra gondoltam!");
    }

    }
}
