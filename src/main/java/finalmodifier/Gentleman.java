package finalmodifier;

import java.util.Scanner;

public class Gentleman {

    public static final String MESSAGE_PREFIX = "Jó napot kívánok! Érezze jól magát nálunk, kedves ";

    public String sayHello(String name) {
        return MESSAGE_PREFIX + name + "!";
    }

    public static void main(String[] args) {

        Gentleman gentleman = new Gentleman();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem, mutatkozzon be!");
                String name = scanner.nextLine();

        System.out.println(gentleman.sayHello(name));
    }
}