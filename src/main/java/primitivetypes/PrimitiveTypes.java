package primitivetypes;

public class PrimitiveTypes {

    public String toBinaryString(int n) {
        String nToBinaryString = "";
        while (n != 0) {
            int x = n % 2;
            nToBinaryString = x + nToBinaryString;
            n = n / 2;
        }
        int bit = 32;
        for (int i = nToBinaryString.length() + 1; i <= bit; i++) {
            nToBinaryString = 0 + nToBinaryString;
        }
        return nToBinaryString;
    }
}
