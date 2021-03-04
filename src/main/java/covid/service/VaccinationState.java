package covid.service;

public enum VaccinationState {

    NO(0), ONE(1), TWO(2);

    private int value;

    VaccinationState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VaccinationState getState(int number) {
        switch (number) {
            case 0 : return NO;
            case 1 : return ONE;
            case 2 : return TWO;
            default : throw new IllegalArgumentException("Nem létező oltottsági státusz!");
         }
    }
}
