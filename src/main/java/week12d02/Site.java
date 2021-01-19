package week12d02;

public class Site {

    private int oddEven;
    private int length;
    private Fence fenceType;

    public Site(int oddEven, int length, Fence fenceType) {
        this.oddEven = oddEven;
        this.length = length;
        this.fenceType = fenceType;
    }

    public int getOddEven() {
        return oddEven;
    }

    public int getLength() {
        return length;
    }

    public Fence getFenceType() {
        return fenceType;
    }
}
