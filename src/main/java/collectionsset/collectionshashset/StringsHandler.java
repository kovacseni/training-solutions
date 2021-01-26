package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {
        Set<String> uniqueStrings = new HashSet<>();
        boolean isInThere = false;

        for (String s : stringCollection) {
            for (String str : stringCollection) {
                if (str.equals(s)) {
                    isInThere = true;
                    break;
                }
            }
            if (!isInThere) {
                uniqueStrings.add(s);
            }
        }
        return uniqueStrings;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {
        Set<String> identicalStrings = new HashSet<>();

        for (String s : setA) {
            for (String str : setB) {
                if (str.equals(s)) {
                    identicalStrings.add(str);
                    break;
                }
            }
        }
        return identicalStrings;
    }
}
