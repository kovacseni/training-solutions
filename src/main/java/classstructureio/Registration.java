package classstructureio;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        System.out.println("Kérem, adja meg a nevét!");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Kérem, adja meg az e-mail címét!");
        String email = scanner.nextLine();

        System.out.println("A regisztrációs adatok a következők:");
        System.out.println("Név: " + name);
        System.out.println("E-mail cím: " + email);
    }
}
