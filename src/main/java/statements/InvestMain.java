package statements;

import java.util.Scanner;

public class InvestMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mekkora összeget szeretne befektetni?");
        int invest = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Milyen kamatra fekteti be a pénzét");
        int rate = scanner.nextInt();
        scanner.nextLine();

        Investment investment = new Investment(invest, rate);

        System.out.println("Tőke összege: " + investment.getFund() + " Ft");
        System.out.println("Kamatláb: " + rate);

        System.out.println("Hány nap után szeretné kivenni a befektetett pénzét?");
        int days = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hozam " + days + " napra: " + investment.getYield(days) + " Ft");
        System.out.println("Kivett összeg " + days + " nap után: " + investment.close(days) + "Ft");

        System.out.println("Lezárt számláról kivehető összeg: " + investment.close(days) + " Ft");

    }
}
