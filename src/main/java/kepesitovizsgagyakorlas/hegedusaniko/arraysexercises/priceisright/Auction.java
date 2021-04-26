package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.priceisright;

public class Auction {

    public int priceIsRight(int[] bids, int price) {
        int maxBid = -1;
        for (int i : bids) {
            if (i > maxBid && i < price) {
                maxBid = i;
            }
        }
        return maxBid;
    }
}
