public class Circle extends TwoDimensionalShape {
    private double radius = 0;

    Circle(double radius) {
        if (radius < 0.0)
            throw new IllegalArgumentException("The radius for a circle must be a non-zero number");

        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.acos(-1) * radius * radius;
    }

    @Override
    public String toString() {
        return "This object is a circle.      The radius is " + radius + ". The area is " + getArea();
    }
}
