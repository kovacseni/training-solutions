package week12d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StreetTest {

    private List<Site> soldSites;
    private Street street;

    @BeforeEach
    public void setUp() {
        soldSites = new ArrayList<>();
        street = new Street();
        street.sellSite(new Site(0, 10, Fence.PERFECT));
        street.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        street.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        street.sellSite(new Site(0, 9, Fence.PERFECT));
        street.sellSite(new Site(0, 11, Fence.NO_FENCE));
        street.sellSite(new Site(1, 13, Fence.PERFECT));
    }

    @Test
    public void testNumberOfLastSoldSite() {
        Assertions.assertEquals(3, street.numberOfLastSoldSite());
    }

    @Test
    public void testCountStatistics() {
        List<FenceStat> statistics = street.countStatistics();

        Assertions.assertEquals(3, statistics.size());

        Assertions.assertEquals(Fence.PERFECT, statistics.get(0).getFenceType());
        Assertions.assertEquals(3, statistics.get(0).getCount());

        Assertions.assertEquals(Fence.NEED_UPGRADE, statistics.get(1).getFenceType());
        Assertions.assertEquals(2, statistics.get(1).getCount());

        Assertions.assertEquals(Fence.NO_FENCE, statistics.get(2).getFenceType());
        Assertions.assertEquals(1, statistics.get(2).getCount());
    }
}
