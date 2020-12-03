package methodpass.troopers;

public class Position {

    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position must be given!");
        }

        double distance = Math.sqrt(Math.pow(this.posX - position.getPosX(), 2) + Math.pow(this.posY - position.getPosY(), 2));
        return distance;
    }
}
