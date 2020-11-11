package numbers;

public class Circle {

    private final double PI = 3.14;
    int diameter;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return (diameter * PI);
    }

    public double area() {
        return (((double)diameter / 2) * ((double)diameter / 2) * PI );
    }

}
