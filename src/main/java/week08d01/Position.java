package week08d01;

public class Position {

    private int x;
    private int y;
    private double distance;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(((double)x * x) + ((double)y * y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance() {
        return distance;
    }
}
