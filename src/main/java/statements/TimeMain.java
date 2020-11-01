package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy ÓRA időpontot:");
        int ora1 = scanner.nextInt();

        System.out.println("Adjon meg egy PERC időpontot:");
        int perc1 = scanner.nextInt();

        System.out.println("Adjon meg egy MÁSODPERC időpontot:");
        int masodperc1 = scanner.nextInt();

        System.out.println("Adjon meg egy másik ÓRA időpontot:");
        int ora2 = scanner.nextInt();

        System.out.println("Adjon meg egy másik PERC időpontot:");
        int perc2 = scanner.nextInt();

        System.out.println("Adjon meg egy másik MÁSODPERC időpontot:");
        int masodperc2 = scanner.nextInt();

        Time idopont1 = new Time(ora1, perc1, masodperc1);
        Time idopont2 = new Time(ora2, perc2, masodperc2);

        System.out.println("Az első időpont: " + idopont1.toString() + " = " + idopont1.getInMinutes() + " perc");
        System.out.println("A második időpont: " + idopont2.toString() + " = " + idopont2.getInSeconds() + " másodperc");
        System.out.println("Az első időpont korábbi-e, mint a második?  " + idopont1.earlierThan(idopont2));
}

}
