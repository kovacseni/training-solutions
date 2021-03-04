package covid.userinterface;

import covid.service.RegistrationService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class VaccinationListGenerator {

    private RegistrationService service = new RegistrationService();
    private Scanner scanner = new Scanner(System.in);

    public void generateVaccinationList() throws SQLException, IOException {

        LocalDate date = askForDate();
        String postalCode = askForPostalCode();
        service.generateVaccinationListByPostalCode(date, postalCode);

        System.out.println("Az Ön által kért oltási listát a \"covid\" mappában találja.");
    }

    private LocalDate askForDate() {
        int count = 0;
        LocalDate date = null;
        while (count <= 3) {
            System.out.println("Kérem, adja meg az oltás dátumát a következő formátumban: éééé-hh-nn");
            String dateString = scanner.nextLine();
            try {
                date = LocalDate.parse(dateString);
                count = 4;
            } catch (DateTimeParseException dtpe) {
                count++;
                if (count == 3) {
                    throw new IllegalArgumentException("Több próbálkozás nem lehetséges.");
                }
                System.out.println("Nem értelmezhető a dátum. (Összesen 3 próbálkozás lehetséges.)");
            }
        }
        return date;
    }

    private String askForPostalCode() throws SQLException {
        int count = 1;
        String postalCode = "";
        while (count <= 3) {
            System.out.println("Kérem, adja meg az oltást szervező település irányítószámát:");
            postalCode = scanner.nextLine();
            String town = service.getTown(postalCode);
            if (!town.isEmpty()) {
                count = 4;
            } else if (count == 3) {
                throw new IllegalArgumentException("Több próbálkozás nem lehetséges.");
            } else {
                count++;
                System.out.println("Nem létező irányítószám. (Összesen 3 próbálkozás lehetséges.)");
            }
        }
        return postalCode;
    }
}
