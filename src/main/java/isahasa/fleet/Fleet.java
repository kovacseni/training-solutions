package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private int waitingPersons;
    private int waitingCargo;

    private List<Ship> shipList = new ArrayList<>();

    public void addShip(Ship newShip) {
        shipList.add(newShip);
    }

    public void loadShip(int passengers, int cargoWeight) {
        int remainingPersons = passengers;
        int remainingCargo = cargoWeight;

        for (Ship ship: shipList) {
            if (ship instanceof CanCarryPassengers) {
                if(remainingPersons != 0) {
                    remainingPersons = ((CanCarryPassengers) ship).loadPassenger(remainingPersons);
                }
            }
            if (ship instanceof CanCarryGoods) {
                if (remainingCargo != 0) {
                    remainingCargo = ((CanCarryGoods) ship).loadCargo(remainingCargo);
                }
            }
        }

        waitingPersons = remainingPersons;
        waitingCargo = remainingCargo;
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
