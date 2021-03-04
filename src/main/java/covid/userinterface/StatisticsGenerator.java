package covid.userinterface;

import covid.service.RegistrationService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class StatisticsGenerator {

    private RegistrationService service = new RegistrationService();
    private Scanner scanner = new Scanner(System.in);

    public void generateStatistics() throws SQLException, IOException {
        System.out.println("Kérem, adja meg, milyen statisztikát szeretne:");
        System.out.println();
        System.out.println("1. Egy adott településre vonatkozó statisztika");
        System.out.println("2. Országos statisztika");
        String statMode = scanner.nextLine();

        if (!statMode.equals("1") && !statMode.equals("2")) {
            System.out.println("Nem létező menüpont.");
            return;
        }

        System.out.println();
        System.out.println("Válassza ki, milyen formában kéri az Ön által választott statisztikát:");
        System.out.println();
        System.out.println("1. Ide, a felületre kiírva kérem az adatokat.");
        System.out.println("2. Fájlba kiírva kérem az adatokat a \"covid\" mappába. (Alapértelmezett)");
        String statForm = scanner.nextLine();

        if (statMode.equals("1") && statForm.equals("1")) {
            String postalCode = askForPostalCode();
            String town = service.getTown(postalCode);
            Map<String, Integer> townStatistics = service.getTownStatistics(postalCode);
            System.out.println("Oltási statisztika " + postalCode + ", " + town + " településre:");
            System.out.println(townStatistics);
        }

        else if (statMode.equals("1")) {
            String postalCode = askForPostalCode();
            service.writeTownStatisticsToFile(postalCode);
        }

        else if (statMode.equals("2") && statForm.equals("1")) {
            Map<String, Map<String, Integer>> hungaryStatistics = service.getHungaryStatistics();
            System.out.println("Országos oltási statisztika:");
            for (String s : hungaryStatistics.keySet()) {
                String town = service.getTown(s);
                System.out.println(s + " " + hungaryStatistics.get(s).toString());
            }
        }

        else if (statMode.equals("2")) {
            service.writeHungaryStatisticsToFile();
        }
    }

    private String askForPostalCode() throws SQLException {
        String postalCode = "";
        int count = 1;
        while (count <= 3) {
            System.out.println("Adja meg a település irányítószámát, melynek oltási adataira kíváncsi:");
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
