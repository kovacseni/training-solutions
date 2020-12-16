package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers {
    
    private CanCarryPassengers canCarryPassengers;

    public Liner(int maxPassenger) {
        canCarryPassengers = new CanCarryPassengersBehaviour(maxPassenger);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }
}
