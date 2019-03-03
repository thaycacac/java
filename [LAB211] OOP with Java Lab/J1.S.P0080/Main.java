
/**
 *
 * @author THAYCACAC
 */
/*
Title 
  Shapes
Background 
    NA
Program Specifications
    Implement the Shape hierarchy shown in above figure. Each two-dimensional shape should contains method getArea() to calculate the area of it (e.g area of a circle is pi* r2).
    Each three-dimensional shape should contain getArea() and getVolume() methods to calculate the surface area and volume respectively.
    Create a program that u	ses an array of Shape references to objects of each concrete class in the hierarchy. The program should print the object to which each array element refers. 
    Also in the loop that processes all the shapes in the array, determine whether each shape is a two-dimensional shape or three-dimensional shape. If a shape is two-dimensional one, display its area. If a shape is three -dimensional one, display its area and volume.
    Expectation of User interface: 
    NA
Guidelines
*/
public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println("Area Circle: " + circle.getArea());

        Shape square = new Square(5);
        System.out.println("Area Square: " + square.getArea());

        Shape triangle = new Triangle(3, 4, 5);
        System.out.println("Area Triangle: " + triangle.getArea());

        Shape sphere = new Sphere(5);
        System.out.println("Area Sphere: " + sphere.getArea());
        System.out.println("Volume Sphere: " + sphere.getVolume());

        Shape cube = new Cube(5);
        System.out.println("Area Cube: " + cube.getArea());
        System.out.println("Volume Cube: " + cube.getVolume());

        Shape tetraheron = new Tetraheron(5);
        System.out.println("Area Sphere: " + tetraheron.getArea());
        System.out.println("Volume Sphere: " + tetraheron.getVolume());
    }
}
