package covid;

import covid.userinterface.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CovidVaccineMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Üdvözöljük a Covid-vakcina regisztrációs felületén!");
        System.out.println();

        System.out.println("Kérem, válasszon az alábbi menüpontok közül:");
        System.out.println();
        System.out.println("1. Egyéni regisztráció");
        System.out.println("2. Csoportos regisztráció");
        System.out.println("3. Korábbi regisztráció megváltoztatása");
        System.out.println("4. Oltási névsor letöltése településenként, adott napra");
        System.out.println("5. Oltás bejegyzése");
        System.out.println("6. Oltás meghiúsulásának bejegyzése");
        System.out.println("7. Oltási statisztika");

        String number = scanner.nextLine();

        if (number.equals("1")) {
            try {
                Registration registration = new Registration();
                registration.registrate();
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else if (number.equals("2")) {
            try {
                MassRegistration mass = new MassRegistration();
                mass.registrateMass();
            } catch (IOException | NullPointerException e) {
                throw new IllegalStateException("Can not read or write file.", e);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else if (number.equals("3")) {
            try {
                UpdateRegistration update = new UpdateRegistration();
                update.updateRegistration();
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else if (number.equals("4")) {
            try {
                VaccinationListGenerator generator = new VaccinationListGenerator();
                generator.generateVaccinationList();
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read or write file.", ioe);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else if (number.equals("5")) {
            try {
                Vaccination vaccination = new Vaccination();
                vaccination.vaccinate(true);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else if (number.equals("6")) {
            try {
                Vaccination vaccination = new Vaccination();
                vaccination.vaccinate(false);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else if (number.equals("7")) {
            try {
                StatisticsGenerator generator = new StatisticsGenerator();
                generator.generateStatistics();
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read or write file.", ioe);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not connect to database.", sqle);
            }
        }

        else {
            System.out.println("Nem létező menüpont. Viszontlátásra!");
        }

        System.out.println();
        System.out.println("Köszönjük, hogy használta a felületet!");
        System.out.println("Köszönjük, hogy Ön is az egészséget választja!");
    }
}
