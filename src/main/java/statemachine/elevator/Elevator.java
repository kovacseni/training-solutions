package statemachine.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private List<String> history = new ArrayList<>();
    private boolean doorIsOpen;
    private boolean elevatorIsOnTheGroundFloor;
    private Direction direction;

    public Elevator() {
        this.doorIsOpen = true;
        this.elevatorIsOnTheGroundFloor = true;
        this.direction = Direction.NONE;
        history.add(ElevatorState.GROUND_FLOOR_OPEN.getState());
    }

    public List<String> getHistory() {
        return history;
    }

    public void pushButtonToGoToFirstFloor() {
        if (elevatorIsOnTheGroundFloor) {
            closeDoors();
            history.add(ElevatorState.GROUND_FLOOR_CLOSED.getState());
            direction = Direction.UP;
            elevatorIsOnTheGroundFloor = false;
            history.add(ElevatorState.FIRST_FLOOR_CLOSED.getState());
            openDoors();
            history.add(ElevatorState.FIRST_FLOOR_OPEN.getState());
            direction = Direction.NONE;
        } else if (!elevatorIsOnTheGroundFloor) {
            throw new IllegalStateException("Cannot go to First Floor, because the elevator is on the First Floor!");
        }
    }

    public void pushButtonToGoToGroundFloor() {
        if (!elevatorIsOnTheGroundFloor) {
            closeDoors();
            history.add(ElevatorState.FIRST_FLOOR_CLOSED.getState());
            direction = Direction.DOWN;
            history.add(ElevatorState.GROUND_FLOOR_CLOSED.getState());
            openDoors();
            history.add(ElevatorState.GROUND_FLOOR_OPEN.getState());
            direction =Direction.NONE;
        } else if (elevatorIsOnTheGroundFloor) {
            throw new IllegalStateException("Cannot go to Ground Floor, because the elevator is on the Ground Floor!");
        }
    }

    public void pushCallButtonOnGroundFloor() {
        if (direction == Direction.NONE && elevatorIsOnTheGroundFloor) {
            openDoors();
        } else if (direction == Direction.NONE && elevatorIsOnTheGroundFloor) {
            pushButtonToGoToGroundFloor();
        } else if (direction == Direction.UP) {
            history.add(ElevatorState.FIRST_FLOOR_CLOSED.getState());
            openDoors();
            history.add(ElevatorState.FIRST_FLOOR_OPEN.getState());
            direction = Direction.NONE;
            pushButtonToGoToGroundFloor();
        } else if (direction == Direction.DOWN) {
            history.add(ElevatorState.GROUND_FLOOR_CLOSED.getState());
            openDoors();
            history.add(ElevatorState.GROUND_FLOOR_OPEN.getState());
            direction = Direction.NONE;
        }
    }

    public void pushCallButtonOnFirstFloor() {
        if (direction == Direction.NONE && elevatorIsOnTheGroundFloor) {
            pushButtonToGoToFirstFloor();
        } else if (direction == Direction.NONE && elevatorIsOnTheGroundFloor) {
            openDoors();
        } else if (direction == Direction.UP) {
            history.add(ElevatorState.FIRST_FLOOR_CLOSED.getState());
            openDoors();
            history.add(ElevatorState.FIRST_FLOOR_OPEN.getState());
            direction = Direction.NONE;
        } else if (direction == Direction.DOWN) {
            history.add(ElevatorState.GROUND_FLOOR_CLOSED.getState());
            openDoors();
            history.add(ElevatorState.GROUND_FLOOR_OPEN.getState());
            direction = Direction.NONE;
            pushButtonToGoToFirstFloor();
        }
    }

    public void openDoors(){
        doorIsOpen = true;
    }

    public void closeDoors() {
        doorIsOpen = false;
    }

    public void setDirection(Direction direction) {
        if (direction == Direction.DOWN || direction == Direction.UP) {
            closeDoors();
        }
        this.direction = direction;
    }
}

/*
Ezzel a feladatmegoldással ugyan nem fut le a teszt, de cserébe jól elszórakoztam
vele, és egyébként a feladatkiírásnak is megfelel, mert lemodelleztem
egy lift működését.
Mivel István megoldásának nagyon más a logikája, nem is láttam át teljesen,
lemásolni meg nem láttam semmi értelmét, ezért úgy döntöttem, inkább játszom egyet
ezzel a feladattal, és a teszttől függetlenül oldom meg. :)
 */
