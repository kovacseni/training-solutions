package ioconvert.shopping;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream os, List<String> shoppingList) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String s : shoppingList) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    public List<String> loadShoppingList(InputStream is) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                shoppingList.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return shoppingList;
    }
}
