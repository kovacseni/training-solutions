package week14d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IndexerTest {

    @Test
    public void testIndex() {
        List<String> nameList = Arrays.asList("Abraham", "Lujza", "Odon", "Magdolna", "Ludmilla", "Laszlo", "Ottokar", "Ajtony");
        Assertions.assertEquals("{A=[Abraham, Ajtony], L=[Lujza, Ludmilla, Laszlo], M=[Magdolna], O=[Odon, Ottokar]}", new Indexer().index(nameList).toString());
    }

    @Test
    public void testIndex2() {
        List<String> nameList = Arrays.asList("Abraham", "Lujza", "Odon", "Magdolna", "Ludmilla", "Laszlo", "Ottokar", "Ajtony");
        Map<Character, List<String>> expected = Map.of('A', Arrays.asList("Abraham", "Ajtony"), 'L', Arrays.asList("Lujza", "Ludmilla", "Laszlo"), 'M', Arrays.asList("Magdolna"), 'O', Arrays.asList("Odon", "Ottokar"));
        Assertions.assertEquals(expected, new Indexer().index(nameList));
    }
}
