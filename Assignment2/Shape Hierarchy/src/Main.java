public class Main {
    public static void main(String[] argv) {
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

        // Tetrahedron tetrahedron = new Tetrahedron(1,2,4,4,0,3,1,1,7, 3,2,1);
        Tetrahedron tetrahedron = new Tetrahedron(0,0,0,1,0,0,0,1,0,0,0,1);
        System.out.println(tetrahedron.toString());
        // System.out.println(tetrahedron.convertedToString());
    }
}
