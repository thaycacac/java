
import java.util.Scanner;

public class Main {
    
    static void print(String s) throws MyException, Exception{
        if(s==null) throw new MyException("Parameter cannot be nulll");
    }

    public static void main(String[] args){
        
        boolean keepGoing = true;
        double mark = 0;
        while (keepGoing) {
            System.out.println("Enter a student mark: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            try {
                print(null);
                mark = Double.valueOf(s);
                if (mark < 0 || mark > 10) {
                    throw new MyException("Student mark must be in rangeof [0, 10]");
                }
                keepGoing = false;
            } catch (MyException e) {
                e.printMessage();
            } catch (Exception e) {
                System.out.println("Student mark must be a numeric");
            }
        }
        System.out.println("Thanks you, your mark is " + mark);

       try {
           int[] a = new int[3];
           a[3] = 3;
           int b = 1;
           a[1] = a[0] / --b;
       } catch (ArithmeticException ex) {
           System.out.println(ex.getMessage());
       } catch (ArrayIndexOutOfBoundsException ex) {
           System.out.println("Array index is invalid");
       } catch (Exception ex) {
           System.out.println(ex);
       } finally {
           //clean-up
       }
       System.out.println("End of program");
    }
}
