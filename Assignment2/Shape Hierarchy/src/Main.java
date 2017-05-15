import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        double number = sc.nextDouble();
        System.out.println("The number you entered is " + number + "\n");

        try {
            Circle circle = new Circle(number);
            System.out.println(circle.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Square square = new Square(number);
            System.out.println(square.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Triangle triangle = new Triangle(number, number, number);
            System.out.println(triangle.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Cube cube = new Cube(number);
            System.out.println(cube.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Sphere sphere = new Sphere(number);
            System.out.println(sphere.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Tetrahedron tetrahedron = new Tetrahedron(number, number, 0, 0, number, number, number, 0, number, 0, 0, 0);
            System.out.println(tetrahedron.toString());
            // System.out.println(tetrahedron.convertedToString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }


//        Circle circle = new Circle(1.0);
//        System.out.println(circle.toString());
//
//        Square square = new Square(10.0);
//        System.out.println(square.toString());
//
//        Triangle triangle = new Triangle(3, 4, 5);
//        System.out.println(triangle.toString());
//
//        Cube cube = new Cube(10);
//        System.out.println(cube.toString());
//
//        Sphere sphere = new Sphere(10);
//        System.out.println(sphere.toString());
//
//        // Tetrahedron tetrahedron = new Tetrahedron(1,2,4,4,0,3,1,1,7, 3,2,1);
//        Tetrahedron tetrahedron = new Tetrahedron(0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1);
//        System.out.println(tetrahedron.toString());
//        // System.out.println(tetrahedron.convertedToString());
    }
}
