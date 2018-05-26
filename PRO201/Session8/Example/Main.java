package Example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean keepGoing = true;
        Triangle t = new Triangle();
        while (keepGoing) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter a: ");
                int a = Integer.valueOf(in.nextLine());
                System.out.print("Enter b: ");
                int b = Integer.valueOf(in.nextLine());
                System.out.print("Enter c: ");
                int c = Integer.valueOf(in.nextLine());
                t = new Triangle(a, b, c);
                keepGoing = false;
            } catch (MyException e) {
                e.printMessage();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a correct data");
            } catch (Exception e) {
                System.out.println("reEnter values for a, b, c they are not a triangle");
            }
        }
        System.out.println("Thanks you, triangle area is " + t.getArea());
    }

}
