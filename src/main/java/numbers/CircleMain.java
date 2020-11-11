package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Az első kör átmérője: ");
        int diameter1 = Integer.parseInt(scanner.nextLine());
        Circle circle1 = new Circle(diameter1);
        System.out.println("Az első kör kerülete: " + circle1.perimeter() + " egység.");
        System.out.println("Az első kör területe: " + circle1.area() + " egységnégyzet.");

        System.out.println();

        System.out.println("A második kör átmérője: ");
        int diameter2 = Integer.parseInt(scanner.nextLine());
        Circle circle2 = new Circle(diameter2);
        System.out.println("A második kör kerülete: " + circle2.perimeter() + " egység.");
        System.out.println("A mésodik kör területe: " + circle2.area() + " egységnégyzet.");

    }
}
