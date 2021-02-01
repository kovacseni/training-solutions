package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> nameMap =new TreeMap<>();
        for (String s : names) {
            if (!nameMap.containsKey(s.charAt(0))) {
                List<String> nameList = new ArrayList<>();
                nameList.add(s);
                nameMap.put(s.charAt(0), nameList);
            } else {
                nameMap.get(s.charAt(0)).add(s);
            }
        }
        return nameMap;
    }
}
