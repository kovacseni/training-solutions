package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg az első számot:");
        int szam1 = scanner.nextInt();
        System.out.println("Adja meg az második számot:");
        int szam2 = scanner.nextInt();
        System.out.println("Adja meg az harmadik számot:");
        int szam3 = scanner.nextInt();
        System.out.println("Adja meg az negyedik számot:");
        int szam4 = scanner.nextInt();
        System.out.println("Adja meg az ötödik számot:");
        int szam5 = scanner.nextInt();

        int sum = szam1 + szam2 + szam3 + szam4 + szam5;
        System.out.println("Az Ön által megadott 5 szám összege: " + sum);

    }
}
