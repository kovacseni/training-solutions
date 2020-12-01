package methodstructure.bmi;

public class BodyMass {

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return (weight / (height * height));
    }

    public BmiCategory body() {
        BmiCategory bmi = null;

        if (bodyMassIndex() < 18.5) {
            bmi = BmiCategory.UNDERWEIGHT;
        } else if (bodyMassIndex() > 25.0) {
            bmi = BmiCategory.OVERWEIGHT;
        } else {
            bmi = BmiCategory.NORMAL;
        }
       return bmi;
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        return (bodyMassIndex() < bodyMass.bodyMassIndex());
    }
}
