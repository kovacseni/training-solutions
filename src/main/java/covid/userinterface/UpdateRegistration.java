package covid.userinterface;

import covid.service.RegistrationService;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRegistration {

    private RegistrationService service = new RegistrationService();
    private Scanner scanner = new Scanner(System.in);

    public void updateRegistration() throws SQLException {

        System.out.println("Kérem, adja meg a TAJ-számot, amellyel regisztrált:");
        String ssn = scanner.nextLine();
        if (!service.checkIfThisPersonIsRegistratedBefore(ssn)) {
            System.out.println("Ezzel a TAJ-számmal még nincsen regisztráció a rendszerben. Viszontlátásra!");
            return;
        }

        System.out.println("Kérem, válasszon, mely regisztrációs adatát szeretné megváltoztatni:");
        System.out.println("1. Név");
        System.out.println("2. Irányítószám");
        System.out.println("3. Életkor");
        System.out.println("4. E-mail cím");
        System.out.println("5. Teljes regisztráció törlése");
        System.out.println("6. Teljes regisztráció törlése és új regisztráció");

        String number = scanner.nextLine();

        if (number.equals("1")) {
            updateName(ssn);
        } else if (number.equals("2")) {
            updatePostalCode(ssn);
        } else if (number.equals("3")) {
            updateAge(ssn);
        } else if (number.equals("4")) {
            updateEmail(ssn);
        } else if (number.equals("5")) {
            service.deleteRegistration(ssn);
        } else if (number.equals("6")) {
            service.deleteRegistration(ssn);
            service.newRegistration();
        } else {
            System.out.println("Nem létező menüpont. Viszontlátásra!");
        }
    }

    private void updateName(String ssn) throws SQLException {
        System.out.println("Adja meg, mire szeretné megváltoztatni a nevét:");
        String name = scanner.nextLine();
        if (service.checkName(name)) {
            service.updateName(ssn, name);
            System.out.println("Adatainak megváltoztatása sikeres volt.");
        } else {
            System.out.println("A név nem lehet üres.");
            System.out.println("Adatainak megváltoztatása nem volt sikeres.");
        }
    }

    private void updatePostalCode(String ssn) throws SQLException {
        System.out.println("Adja meg, mire szeretné megváltoztatni az irányítószámát:");
        String postalCode = scanner.nextLine();
        if (service.postalCodeIsOKAndValid(postalCode)) {
            service.updatePostalCode(ssn, postalCode);
            System.out.println("Adatainak megváltoztatása sikeres volt.");
        } else {
            System.out.println("Nem megfelelő irányítószám.");
            System.out.println("Adatainak megváltoztatása nem volt sikeres.");
        }
    }

    private void updateAge(String ssn) throws SQLException {
        System.out.println("Adja meg, mire szeretné megváltoztatni az életkorát:");
        String ageString = scanner.nextLine();
        if (service.ageIsNumberAndIsOK(ageString)) {
            int age = Integer.parseInt(ageString);
            service.updateAge(ssn, age);
            System.out.println("Adatainak megváltoztatása sikeres volt.");
        } else {
            System.out.println("Nem megfelelő az életkor.");
            System.out.println("Adatainak megváltoztatása nem volt sikeres.");
        }
    }

    private void updateEmail(String ssn) throws SQLException {
        System.out.println("Adja meg, mire szeretné megváltoztatni az e-mail címét:");
        String email = scanner.nextLine();
        if (service.checkEmail(email)) {
            System.out.println("Adja meg még egyszer az új e-mail címet:");
            String email2 = scanner.nextLine();
            if (service.checkEmail2(email, email2)) {
                service.updateEmail(ssn, email);
                System.out.println("Adatainak megváltoztatása sikeres volt.");
            } else {
                System.out.println("Nem egyezik az email cím.");
                System.out.println("Adatainak megváltoztatása nem volt sikeres.");
            }
        } else {
            System.out.println("Nem megfelelő email cím.");
            System.out.println("Adatainak megváltoztatása nem volt sikeres.");
        }
    }
}
