public class Square extends TwoDimensionalShape {
    double edge;

    public Square(double edge) {
        if (edge < 0.0) {
            throw new IllegalArgumentException("The edge length must be a non-zero number");
        }
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return edge * edge;
    }

    @Override
    public String toString() {
        return "This object is a square. The edge length is " + edge + " and the area is " + getArea();
    }

}
