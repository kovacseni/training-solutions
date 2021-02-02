package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class OnlineShopping {

    private Map<String, List<String>> shoppingList = new LinkedHashMap<>();

    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String[] items = parts[1].split(",");
                List<String> result = new ArrayList<>();
                for (String s : items) {
                    result.add(s);
                }
                shoppingList.put(parts[0], result);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public List<String> getItemById(String id) {
        List<String> result = new ArrayList<>(shoppingList.get(id));
        Collections.sort(result);
        return result;
    }

    public List<String> getItemByIdReversed(String id) {
        List<String> result = getItemById(id);
        Collections.reverse(result);
        return result;
    }

    public int getNumberOfItemSold(String input) {
        int count = 0;
        Collection<List<String>> values = shoppingList.values();
        List<String> result= new ArrayList<>();
        for(List<String> item : values) {
            for(String s : item) {
                if(s.equals(input)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumberOfItemsById(String id) {
        return shoppingList.get(id).size();
    }

    public Map<String,Integer> shoppingListStatistics() {
        Map<String,Integer> result = new HashMap<>();
        for(List<String> item : shoppingList.values()) {
            for(String s : item) {
                int count = getNumberOfItemSold(s);
                result.put(s,count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OnlineShopping os = new OnlineShopping();
        os.readFile(Path.of("src/main/resources/shopping.txt"));
        List<String> result = os.getItemById("B3402");
        System.out.println(result);
        List<String> resultReverse = os.getItemByIdReversed("B3402");
        System.out.println(resultReverse);
        int resultCount = os.getNumberOfItemSold("tomato");
        System.out.println(resultCount);
        int sizeList = os.getNumberOfItemsById("B3402");
        System.out.println(sizeList);
        Map<String,Integer> resultMap = os.shoppingListStatistics();
        System.out.println(resultMap);
    }
}
