
public class Main {
	public static void main(String[] argv)
	{
		Circle circle = new Circle(1.0);
		System.out.println(circle.toString());
		
		Square square = new Square(10.0);
		System.out.println(square.toString());
		
		Triangle triangle = new Triangle(3, 4, 5);
		System.out.println(triangle.toString());
		
		Cube cube = new Cube(10);
		System.out.println(cube.toString());
		
		Sphere sphere = new Sphere(10);
		System.out.println(sphere.toString());
	}
}
