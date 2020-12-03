package methodpass.troopers;

public class Trooper {

    private String name;
    private Position position;

    public Trooper(String name) {
        if (name == null || "".equals(name) || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        this.position = new Position(0, 0);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void changePosition(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("New position must not be empty!");
        }
        this.position = target;
    }

    public double distanceFrom(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("New position must not be empty!");
        }
       return this.position.distanceFrom(target);
    }
}
