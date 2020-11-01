package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hány fő részére szeretne csónakot bérelni?");
        int szemely = scanner.nextInt();

        if (szemely == 0) {
            System.out.println("Még 10 fő részére tudunk csónakot biztosítani.");

        }
        if (szemely == 1) {
            System.out.println("Ön a kétszemélyes csónakot bérelheti ki. A bent maradt csónakjainkban még további 8 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 2) {
            System.out.println("Önök a kétszemélyes csónakot bérelhetik ki. A bent maradt csónakjainkban még további 8 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 3) {
            System.out.println("Önök a háromszemélyes csónakot bérelhetik ki. A bent maradt csónakjainkban még további 7 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 4) {
            System.out.println("Önök az ötszemélyes csónakot bérelhetik ki. A bent maradt csónakjainkban még további 5 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 5) {
            System.out.println("Önök az ötszemélyes csónakot bérelhetik ki. A bent maradt csónakjainkban még további 5 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 6) {
            System.out.println("Önök az öt- és a kétszemélyes csónakot bérelhetik ki. A bent maradt csónakunkban még további 3 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 7) {
            System.out.println("Önök az öt- és a kétszemélyes csónakot bérelhetik ki. A bent maradt csónakunkban még további 3 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 8) {
            System.out.println("Önök az öt- és a háromszemélyes csónakot bérelhetik ki. A bent maradt csónakunkban még további 2 fő részére tudunk helyet biztosítani.");

        }
        if (szemely == 9) {
            System.out.println("Önök az öt-, a három- és a kétszemélyes csónakot bérelhetik ki. Mivel így nem marad bent több csónakunk, ezért nem tudunk helyet biztosítani további személyek számára.");

        }
        if (szemely == 10) {
            System.out.println("Önök az öt-, a három- és a kétszemélyes csónakot bérelhetik ki. Mivel így nem marad bent több csónakunk, ezért nem tudunk helyet biztosítani további személyek számára.");

        }
        if (szemely > 10) {
            System.out.println("Önök az öt-, a három- és a kétszemélyes csónakot bérelhetik ki. Mivel így nem marad bent több csónakunk, ezért Önök közül " + (szemely-10) + " személynek már nem tudunk helyet biztosítani. Sajnos további kölcsönzési igényeket sem tudunk kiszolgálni.");

        }

    }
}
