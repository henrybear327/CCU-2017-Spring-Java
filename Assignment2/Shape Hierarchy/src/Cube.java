
public class Cube extends ThreeDimensionalShape {
	double edge;
	
	Cube(double edge)
	{
		if(edge < 0.0)
			throw new IllegalArgumentException("The edge length must be a non-zero number");
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
		return "This object is a cube. The edge length is " + edge + ", the area is " + getArea() + ", and the volume is " + getVolume();
	}

}
