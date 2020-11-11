package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Oldja meg az alábbi műveletsort, majd gépelje be az eredményt: ");
        System.out.println("2 * (43 + 3 / 5 + 81 - 20 / 8 + 2 * 6 * 4 / (32 - 1 * 2) + 13 ) + 25 = ");
        double megoldas = scanner.nextDouble();

        double igaziMegoldas = 2.0 * (43.0 + 3.0 / 5.0 + 81.0 - 20.0 / 8.0 + 2.0 * 6.0 * 4.0 / (32.0 - 1.0 * 2.0) + 13.0 ) + 25.0;
        if (Math.abs(igaziMegoldas - megoldas) < 0.0001 ) {
            System.out.println("Mivel a kifejezés eredménye " + igaziMegoldas + ", ezért az Ön megoldása helyes.");
        } else {
            System.out.println("Mivel a kifejezés eredménye " + igaziMegoldas + ", ezért az Ön megoldása helytelen.");
        }
    }
}
