package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Pendrive típusa: %s, kapacitása: %d, ára: %d Ft.", name, capacity, price);
    }

    public void risePrice(int percent) {
        this.price += this.price * (percent / 100.0);
         }

    public int comparePricePerCapacity(Pendrive otherPendrive) {
        double pendrivePricePerCapacity = ((double)getPrice() / getCapacity());
        double otherPendrivePricePerCapacity = ((double)otherPendrive.getPrice() / otherPendrive.getCapacity());

        int whichIsGreater = 0;
        if (pendrivePricePerCapacity > otherPendrivePricePerCapacity) {
            whichIsGreater = 1;
        } else if (otherPendrivePricePerCapacity > pendrivePricePerCapacity) {
            whichIsGreater = -1;
        }
        return whichIsGreater;
    }

    public boolean cheaperThan(Pendrive otherPendrive) {
        return (getPrice() < otherPendrive.getPrice());
    }
}
