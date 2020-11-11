package operators;

public class Operators {

    public void isEven(int n) {

        if (n % 2 == 0) {
            System.out.println("Ez egy páros szám.");
        } else {
            System.out.println("Ez egy páratlan szám.");
        }
    }

    public int multiplyByPowerOfTwo(int n, int m) {
        return (n << m);
    }


}
