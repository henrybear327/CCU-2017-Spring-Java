public class Square extends TwoDimensionalShape {
    private double edge;

    public Square(double edge) {
        if (edge < 0.0) {
            throw new IllegalArgumentException("The edge length of a square must be a non-zero number");
        }
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return edge * edge;
    }

    @Override
    public String toString() {
        return "This object is a square.      The edge length is " + edge + ". The area is " + getArea();
    }

}
