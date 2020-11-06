package finalmodifier;

import java.util.Scanner;

public class CylinderCalculatorBasedOnCircle {

    CircleCalculator circleCalculator = new CircleCalculator();

    public double calculateVolume(double r, double h){
        return circleCalculator.calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r, double h){
        return circleCalculator.calculatePerimeter(r) * h;
    }

    public static void main(String[] args) {
        CylinderCalculatorBasedOnCircle c = new CylinderCalculatorBasedOnCircle();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Adja meg egy kör sugarát: ");
        double r1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Most adjon meg egy magassági értéket: ");
        double h1 = scanner.nextInt();

        System.out.println("A körre emelt, adott magasságú henger felszíne: " + c.calculateSurfaceArea(r1, h1) + " egységnégyzet.");
        System.out.println("A henger térfogata: " + c.calculateVolume(r1, h1) + " egység a köbön.");
    }
    }
