package week06d05;

public class Bottle {

    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type, int filledUntil) {
        this.type = type;
        this.filledUntil = filledUntil;
    }


    public static Bottle of(BottleType type) {
        return new Bottle(type, 0);
    }

    public boolean fill(int fillAmount) {
        fillAmount =  filledUntil + fillAmount;
        boolean full = fillAmount > type.getMaximumAmount();
        if (full == true) {
            throw new IllegalArgumentException("Ennyi folyadéktól túlcsordul az üveg!");
        }
        return full;
    }

}
