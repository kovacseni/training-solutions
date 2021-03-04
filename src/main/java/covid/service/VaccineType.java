package covid.service;

public enum VaccineType {

    PFIZER, MODERNA, ASTRA_ZENECA, SZPUTNYIK, SINOPHARM;

    public static VaccineType getType(int number) {
        switch (number) {
            case 1 : return PFIZER;
            case 2 : return MODERNA;
            case 3 : return ASTRA_ZENECA;
            case 4 : return SZPUTNYIK;
            case 5 : return SINOPHARM;
            default: throw new IllegalArgumentException("Nem létező vakcinatípus!");
        }
    }
}
