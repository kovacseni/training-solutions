package literals;

public class LiteralsMain {

    public static void main(String[] args) {

        /* Összefűzés */

        String t = "1" + "2";

        String a = "1";
        String b = "2";
        String c = a + b;

        int x = 1;
        int y = 2;
        String z = Integer.toString(x) + Integer.toString(y);

        System.out.println(t);
        System.out.println(c);
        System.out.println(z);

        /* Osztás */

        double quotient = 3 / 4;
        System.out.println(quotient);

        double q1 = 3 / 4.0;
        double q2 = 3.0 / 4;
        double q3 = 3D / 4;
        double q4 = 3 / 4D;
        double q5 = (double) 3 / 4;
        double q6 = 3 / (double) 4;

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        System.out.println(q4);
        System.out.println(q5);
        System.out.println(q6);

        /* Nagy szám */

        long big = 3_244_444_444L;
        System.out.println(big);

        /* Karakterkódolás */

        String s = "árvíztűrőtükörfúrógép";
        System.out.println(s);

        /* Nekem ugyanazt írta ki, felismerte a magyar speciális karaktereket. */

        /* String mint objektum */

        String word = "title".toUpperCase();
        System.out.println(word);

        /* Szám bináris stringként */

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));

    }
}
