package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();

        operators.isEven(2);
        operators.isEven(13);
        operators.isEven(234);
        operators.isEven(5489);

        System.out.println(16 >> 1);
        System.out.println(16 << 1);
        System.out.println(13 >> 1);
        System.out.println(13 << 1);

        System.out.println(operators.multiplyByPowerOfTwo(5, 1));
        System.out.println(operators.multiplyByPowerOfTwo(5, 2));
        System.out.println(operators.multiplyByPowerOfTwo(5, 3));

        /* int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Integer.parseInt(s, 2);
        System.out.println(j); */

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);
        /* Azért ad kivételt, mert az Integer csak 2^31-1-ig értelmez számokat,
        a 32 db 1-esből álló szám pedig ennél nagyobb, ezért ez az osztály
        nem tudja értelmezni. Itt ugyanis nem egy binárisból decimálisba való átalakítást
        adunk utasításba, hanem azt, hogy a bináris, 32 db 1-esből álló számot alakítsa
        Integer-ré. Ilyen nagy számokat a Long osztály tud értelmezni.
         */

        System.out.println(0333);
        /* Mert a 0 karakter miatt 8-as számrendszerben értelmezi a 333-as számot.
        Átváltva ezt 10-es számrendszerbe: 3*1 + 3*8 + 3*64 = 219
         */

    }
}
