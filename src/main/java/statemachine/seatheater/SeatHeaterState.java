package statemachine.seatheater;

public enum SeatHeaterState {

    ONE {
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    },
    TWO {
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    THREE {
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    },
    OFF {
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    };

    abstract SeatHeaterState next();
}
