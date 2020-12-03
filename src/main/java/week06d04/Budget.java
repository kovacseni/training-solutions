package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> itemList = new ArrayList<>();

    public Budget(List<Item> itemList) {
        if (itemList == null || itemList.size() == 0) {
            throw new IllegalArgumentException("Üres lista!");
        }
        this.itemList = itemList;
    }

    public int getItemsByMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Adja meg a hónap számát 1 és 12 között!");
        }

        int sum = 0;
        for (Item i : itemList) {
            if (i.getMonth() == month) {
                sum += i.getPrice();
            }
        }
        return sum;
    }
}
