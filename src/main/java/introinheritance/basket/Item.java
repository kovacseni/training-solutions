package introinheritance.basket;

public class Item {

    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public double getTaxAmount() {
        return this.nettoPrice * (this.vatPercent / 100.0);
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Item{barcode='");
        sb.append(barcode + "', ").append("nettoPrice=" + nettoPrice + ", ").append("vatPercent=" + vatPercent + "}");
        return sb.toString();
    }
}
