import java.util.Scanner;

public class Main {
    private static void numberTest() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        double number = sc.nextDouble();
        System.out.println("The number you entered is " + number + "\n");

        Shape[] arrayOfShape = new Shape[6];
        try {
            arrayOfShape[0] = new Circle(number);
            //System.out.println(arrayOfShape[0].toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            arrayOfShape[0] = null;
        }

        try {
            arrayOfShape[1] = new Square(number);
            //System.out.println(arrayOfShape[1].toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            arrayOfShape[1] = null;
        }

        try {
            arrayOfShape[2] = new Triangle(number, number, number);
            //System.out.println(arrayOfShape[2].toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            arrayOfShape[2] = null;
        }

        try {
            arrayOfShape[3] = new Cube(number);
            //System.out.println(arrayOfShape[3].toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            arrayOfShape[3] = null;
        }

        try {
            arrayOfShape[4] = new Sphere(number);
            //System.out.println(arrayOfShape[4].toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            arrayOfShape[4] = null;
        }

        try {
            arrayOfShape[5] = new Tetrahedron(0, 0, 0, number, 0, 0, 0, number, 0, 0, 0, number);
            //System.out.println(arrayOfShape[5].toString());
            // System.out.println(tetrahedron.convertedToString());
        } catch (Exception e) {
            System.out.println(e.toString());
            arrayOfShape[5] = null;
        }

        for (int i = 0; i < 6; i++) {
            if (arrayOfShape[i] != null) {
                if (TwoDimensionalShape.class.isAssignableFrom(arrayOfShape[i].getClass())) {
                    System.out.println(String.format("arrayOfShape[%d] is a two dimensional shape. %s", i, arrayOfShape[i].toString()));

                    System.out.println(String.format("The area is %.6f", ((TwoDimensionalShape) arrayOfShape[i]).getArea()));
                } else {
                    System.out.println(String.format("arrayOfShape[%d] is a three dimensional shape. %s", i, arrayOfShape[i].toString()));
                    System.out.println(String.format("The area is %.6f, and the volume is %.6f", ((ThreeDimensionalShape) arrayOfShape[i]).getArea(), ((ThreeDimensionalShape) arrayOfShape[i]).getVolume()));
                }
            }
        }
    }

    private static void fixedTest() {
        Circle circle = new Circle(5.0);
        System.out.println(circle.toString());

        Square square = new Square(5.0);
        System.out.println(square.toString());

        Triangle triangle = new Triangle(6, 5, 5);
        System.out.println(triangle.toString());

        Cube cube = new Cube(5);
        System.out.println(cube.toString());

        Sphere sphere = new Sphere(5);
        System.out.println(sphere.toString());

        // Tetrahedron tetrahedron = new Tetrahedron(1,2,4,4,0,3,1,1,7, 3,2,1);
        Tetrahedron tetrahedron = new Tetrahedron(0, 0, 0, 0, 0, 6, 0, 6, 0, 6, 0, 0);
        System.out.println(tetrahedron.toString());
        // System.out.println(tetrahedron.convertedToString());
    }

    public static void main(String[] argv) {
        numberTest();

        // fixedTest();
    }
}
