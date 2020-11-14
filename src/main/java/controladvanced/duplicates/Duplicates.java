package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

    public List<Integer> find(List<Integer> numbers) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    lista.add(numbers.get(i));
                    break;
                }
            }
        }
        return lista;
    }
}
