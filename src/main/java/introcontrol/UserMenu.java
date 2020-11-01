package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználó felvétele");
        System.out.println("Többi: Kilépés");

        System.out.println("");

        System.out.println("Melyik menüpontot választja?");
        int a = scanner.nextInt();

        if (a == 1) {
            System.out.println("1. Felhasználók listázása");
        }

        if (a == 2) {
            System.out.println("2. Felhasználó felvétele");
        }

    }
}
