
public class Tetrahedron extends ThreeDimensionalShape {
	double[] x = new double[4];
	double[] y = new double[4];
	
	public Tetrahedron(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
		x[0] = x0;
		y[0] = y0;
		
		x[1] = x1;
		y[1] = y1;
		
		x[2] = x2;
		y[2] = y2;
		
		x[3] = x3;
		y[3] = y3;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVolume() {
		double res = 0;
		
		// https://en.wikipedia.org/wiki/Tetrahedron#Volume
		
		return res;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
