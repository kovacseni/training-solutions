package enumtype.unit;

public enum LengthUnit {

    MILLIMETER(true, 1), CENTIMETER(true, 10), METER(true, 1000), YARD(false, 914.4), FOOT(false, 304.8), INCH(false, 25.4);

    private boolean isSI;
    private double inMm;

    LengthUnit(boolean isSI, double inMm) {
        this.isSI = isSI;
        this.inMm = inMm;
    }

    public boolean getSI() {
        return isSI;
    }

    public double inMm() {
        return inMm;
    }

}
