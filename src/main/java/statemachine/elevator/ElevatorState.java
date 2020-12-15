package statemachine.elevator;

public enum ElevatorState {

    GROUND_FLOOR_OPEN("Ground Floor Open"), GROUND_FLOOR_CLOSED("Ground Floor Closed"), FIRST_FLOOR_CLOSED("First Floor Closed"), FIRST_FLOOR_OPEN("First Floor Open");

    private String state;

    ElevatorState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
