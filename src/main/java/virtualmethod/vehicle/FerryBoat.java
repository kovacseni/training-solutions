package virtualmethod.vehicle;

public class FerryBoat extends Vehicle {

    private static final int MAX_CARRY_WEIGHT = 2000;
    private Car car;

    public FerryBoat(int kg) {
        super(kg);
    }

    @Override
    public int getGrossLoad() {
        return car.getGrossLoad() + super.getGrossLoad();
    }

    public boolean canCarry(Car car) {
        return car.getGrossLoad() < MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car) {
        if (car.getGrossLoad() < MAX_CARRY_WEIGHT) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FerryBoat{car=" + car.toString() + "}";
    }

}
