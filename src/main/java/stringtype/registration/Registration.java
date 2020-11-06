package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {

        UserValidator user = new UserValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Felhasználónév: ");
        String username = scanner.nextLine();

        System.out.println("Jelszó: ");
        String password1 = scanner.nextLine();

        System.out.println("Jelszó megerősítése: ");
        String password2 = scanner.nextLine();

        System.out.println("E-mail cím: ");
        String email = scanner.nextLine();

        System.out.println(user.isValidUsername(username) ? "A felhasználónév rendben van." : "A felhasználónév helytelen.");
        System.out.println(user.isValidPassword(password1, password2) ? "A jelszó megfelelő." : "A jelszó helytelen.");
        System.out.println(user.isValidEmail(email) ? "Az e-mail cím rendben van." : "Az e-mail cím helytelen.");
    }
}
