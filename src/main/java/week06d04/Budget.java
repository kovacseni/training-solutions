package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> itemList;

    public Budget(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemsByMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Adja meg a hónap számát 1 és 12 között!");
        }

        List<Item> listOfItemsByMonth = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getMonth() == month) {
                listOfItemsByMonth.add(itemList.get(i));
            }
        }
        return listOfItemsByMonth;
    }
}
