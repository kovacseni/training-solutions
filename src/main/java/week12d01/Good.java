package week12d01;

public class Good {

    private int kg;
    private int value;

    public Good(int kg, int value) {
        this.kg = kg;
        this.value = value;
    }

    public int getKg() {
        return kg;
    }

    public int getValue() {
        return value;
    }

    public int getRate() {
        return (int)((double)value / (double)kg);
    }
}
