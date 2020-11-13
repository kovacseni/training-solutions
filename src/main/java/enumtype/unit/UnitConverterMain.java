package enumtype.unit;

import java.math.BigDecimal;
import java.util.Arrays;

public class UnitConverterMain {

    public static void main(String[] args) {

        UnitConverter u = new UnitConverter();
        BigDecimal b1 = new BigDecimal(5670);
        BigDecimal b2 = new BigDecimal(346465786);

        System.out.println(u.convert(b1, LengthUnit.CENTIMETER, LengthUnit.METER));
        System.out.println(u.convert(b2, LengthUnit.MILLIMETER, LengthUnit.METER));

        System.out.println(Arrays.toString(LengthUnit.values()));
        System.out.println(u.siUnits());

    }
}
