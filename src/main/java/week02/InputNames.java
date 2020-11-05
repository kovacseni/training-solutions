package week02;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nevek = new String[5];

        for (int i=0; i < 5; i++) {
            System.out.println("Adjon meg egy nevet!");
            nevek[i] = scanner.nextLine();
        }

        int i = 1;
        for (String elem : nevek) {
            System.out.println(i + ". név: " + elem);
            i++;
        }
    }
}
