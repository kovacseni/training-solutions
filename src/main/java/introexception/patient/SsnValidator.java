package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {

        if (ssn.length() != 9) {
            return false;
        }

        try {
            String a0 = ssn.substring(0, 1);
            int a = Integer.parseInt(a0);
            String b0 = ssn.substring(1, 2);
            int b = Integer.parseInt(b0);
            String c0 = ssn.substring(2, 3);
            int c = Integer.parseInt(c0);
            String d0 = ssn.substring(3, 4);
            int d = Integer.parseInt(d0);
            String e0 = ssn.substring(4, 5);
            int e = Integer.parseInt(e0);
            String f0 = ssn.substring(5, 6);
            int f = Integer.parseInt(f0);
            String g0 = ssn.substring(6, 7);
            int g = Integer.parseInt(g0);
            String h0 = ssn.substring(7, 8);
            int h = Integer.parseInt(h0);
            String i0 = ssn.substring(8);
            int i = Integer.parseInt(i0);

            int osszeg = (3 * a + 7 * b + 3 * c + 7 * d + 3 * e + 7 * f + 3 * g + 7 * h) % 10;
            return (osszeg == i);
        } catch (IllegalArgumentException iAE) {
            return false;
        }
    }
}
