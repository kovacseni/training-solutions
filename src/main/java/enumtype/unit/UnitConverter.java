package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        BigDecimal big1 = new BigDecimal(source.inMm());
        BigDecimal big2 = new BigDecimal(target.inMm());
        return length.multiply(big1).divide(big2, 4, RoundingMode.HALF_UP);
    }

    public List<LengthUnit> siUnits() {
            List<LengthUnit> listaSI = new ArrayList<>();
        for (LengthUnit u : LengthUnit.values()) {
             if (u.getSI()) {
                 listaSI.add(u);
             }
         }
         return listaSI;
        }

    }
