package week14d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IndexerTest {

    @Test
    public void testIndex() {
        List<String> nameList = Arrays.asList("Abraham", "Lujza", "Odon", "Magdolna", "Ludmilla", "Laszlo", "Ottokar", "Ajtony");
        Assertions.assertEquals("{A=[Abraham, Ajtony], L=[Lujza, Ludmilla, Laszlo], M=[Magdolna], O=[Odon, Ottokar]}", new Indexer().index(nameList).toString());
    }
}
