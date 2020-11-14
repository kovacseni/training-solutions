package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {

    private String word;
    private List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        addTranslations(translations);
    }

    public void addTranslations(List<String> list) {
        for (String s : list) {
            if (!translations.contains(s)) {
                translations.add(s);
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }


    /* Ennél a feladatnál egyszerűen nem stimmel a teszt, de már sokszor átnéztem,
    a megoldások alapján is javítottam benne egy-két kisebb dolgot, de egyszerűen
    nem bírok rájönni, mi a gond.Egyelőre elküldöm, majd később még visszanézek rá.
     */
}
