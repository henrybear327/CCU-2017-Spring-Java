public class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        if (radius < 0.0)
            throw new IllegalArgumentException("The radius of a sphere must be a non-zero number");

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
        // return "This object is a sphere.      The radius is " + radius + ". The area is " + getArea() + ". The volume is " + getVolume();
        return "This object is a sphere. The radius is " + radius + ".";
    }

}
