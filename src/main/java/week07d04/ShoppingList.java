package week07d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {

    private List<String> shoppingList = new ArrayList<>();

    public long calculateSum(String path) {
       try (Scanner scanner = new Scanner(ShoppingList.class.getResourceAsStream(path))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            shoppingList.add(line);
        }
       }
       int sumString = 0;
       for (String s : shoppingList) {
           int index1 = s.indexOf(";");
           int index2 = s.indexOf(";", index1 + 1);
           int quantity = Integer.parseInt(s.substring(index1 + 1, index2));
           int price = Integer.parseInt(s.substring(index2 + 1));
           sumString = sumString + quantity * price;

          /* int quantity = Integer.parseInt(s.substring(s.indexOf(";") + 1, s.indexOf(";", s.indexOf(";") + 1)));
           int price = Integer.parseInt(s.substring(s.indexOf(";", s.indexOf(";") + 1) + 1));
           sumString = sumString + (Integer.parseInt(s.substring(s.indexOf(";") + 1, s.indexOf(";", s.indexOf(";") + 1)))) * (Integer.parseInt(s.substring(s.indexOf(";", s.indexOf(";") + 1) + 1)));*/
       }
       long sum = (long)sumString;
       return sum;
    }
}
