package abstractclass.gamecharacter;

public class Point {

    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point anotherPoint) {
        long anotherX = anotherPoint.getX();
        long anotherY = anotherPoint.getY();
        return (long)Math.sqrt((anotherX * anotherX) + (anotherY * anotherY));
    }
}
