package finalmodifier;

public class CircleCalculator {

    public final static double PI = 3.14;

    public double calculatePerimeter(double r){
        return (2 * r * PI);
    }

    double calculateArea(double r) {
        return (r * r * PI);
    }
}
