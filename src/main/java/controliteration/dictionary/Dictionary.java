package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> words = new ArrayList<>();

    public void addItem(String word, List<String> translations) {
        boolean found = false;
        for (DictionaryItem d : words) {
            if (d.getWord().equals(word)) {
                d.addTranslations(translations);
                found = true;
            }

            if (!found) {words.add(new DictionaryItem(word, translations));
            }
        }
    }

    public List<String> findTranslations(String word) {
        for (DictionaryItem d : words) {
            if (d.getWord().equals(word)) {
                return d.getTranslations();
            }
        }
        return new ArrayList<>();
    }
}
