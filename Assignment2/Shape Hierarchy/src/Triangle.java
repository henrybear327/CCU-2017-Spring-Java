import java.util.Arrays;

public class Triangle extends TwoDimensionalShape {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!((a + b > c) && (a + c > b) && (b + c > a)))
            throw new IllegalArgumentException("The 3 edges given is not valid");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return "This object is a triangle. The egdes are " + a + " " + b + " " + c + ", and the area is " + getArea();
    }

}
