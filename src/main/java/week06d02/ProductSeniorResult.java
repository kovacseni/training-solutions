package week06d02;

public class ProductSeniorResult {
    private int frozen;
    private int dairy;
    private int bakedgoods;
    private int other;

    public ProductSeniorResult(int frozen, int dairy, int bakedgoods, int other) {
        this.frozen = frozen;
        this.dairy = dairy;
        this.bakedgoods = bakedgoods;
        this.other = other;
    }

    public String toString() {
        return String.format("Fagyasztott áru: %d db. Tejtermék: %d db. Pékáru: %d db. Egyéb: %d db.", frozen, dairy, bakedgoods, other);
    }
}
