package week06d05;

public class Biscuit {

    private BiscuitType type;
    private int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType type, int gramAmount) {
        return new Biscuit(type, gramAmount);
    }

    @Override
    public String toString() {
        return type.toString() + ": " + gramAmount + " g";
    }
}
