package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {

        Song zeneSzam = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi a kedvenc zeneszámod? Írd meg nekem az előadóját!");
        zeneSzam.band = scanner.nextLine();

        System.out.println("Add meg a címét is!");
        zeneSzam.title = scanner.nextLine();

        System.out.println("Végül pedig írd ide a szám percben mért hosszát is!");
        zeneSzam.length = scanner.nextInt();

        System.out.println("A kedvenc zeneszám adatai:");
        System.out.println(zeneSzam.band);
        System.out.println(zeneSzam.title);
        System.out.println(zeneSzam.length + "perc");
    }
}
