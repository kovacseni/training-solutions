package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Client ugyfel = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem, adja meg a nevét!");
        ugyfel.name = scanner.nextLine();

        System.out.println("Kérem, adja meg a születési évét!");
        ugyfel.year = scanner.nextInt();

        System.out.println(ugyfel.name);
        System.out.println(ugyfel.year);

    }
}
