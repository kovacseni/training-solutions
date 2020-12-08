package inheritanceconstructor.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car (double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) {
        if (!isEnoughFuel(km)) {
                throw new RuntimeException("Not enough fuel available!");
        }
        fuel -= km * fuelRate / 100.0;
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    private boolean isEnoughFuel(int km) {
        boolean enough = true;
        if (fuel - (km * fuelRate / 100.0) < 0.0) {
            enough = false;
        }
        return enough;
    }
}