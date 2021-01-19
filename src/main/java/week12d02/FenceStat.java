package week12d02;

public class FenceStat {

    private Fence fenceType;
    private int count;

    public FenceStat(Fence fenceType, int count) {
        this.fenceType = fenceType;
        this.count = count;
    }

    public Fence getFenceType() {
        return fenceType;
    }

    public int getCount() {
        return count;
    }
}
