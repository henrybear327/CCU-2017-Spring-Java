public class Cube extends ThreeDimensionalShape {
    private double edge;

    Cube(double edge) {
        if (edge < 0.0)
            throw new IllegalArgumentException("The edge length of the cube must be a non-zero number");
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return 6 * edge * edge;
    }

    @Override
    public double getVolume() {
        return edge * edge * edge;
    }

    @Override
    public String toString() {
        // return "This object is a cube.        The edge length is " + edge + ". The area is " + getArea() + ". The volume is " + getVolume();
        return "This object is a cube. The edge length is " + edge + ".";
    }

}
