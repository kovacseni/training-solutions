package week15d01;

public class BitCoin {

    private int purchase;
    private int sale;

    public BitCoin(int purchase, int sale) {
        this.purchase = purchase;
        this.sale = sale;
    }

    public int getPurchase() {
        return purchase;
    }

    public int getSale() {
        return sale;
    }
}
