public class Sphere extends ThreeDimensionalShape {
    double radius;

    public Sphere(double radius) {
        if (radius < 0.0)
            throw new IllegalArgumentException("The radius must be a non-zero number");

        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.acos(-1) * radius * radius;
    }

    @Override
    public double getVolume() {
        return 4.0 / 3.0 * Math.acos(-1) * radius * radius * radius;
    }

    @Override
    public String toString() {
        return "This object is a sphere. The radius is " + radius + ", the area is " + getArea() + ", and the volume is " + getVolume();
    }

}
