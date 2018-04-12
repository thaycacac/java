
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class HackerRank197 {

    public static double f(double x, double b) {
        return Math.floor(Math.pow(2, b-x*x))*Math.pow(10, -9);
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double u = Double.parseDouble(in.next());
        double b = Double.parseDouble(in.next());
        int n = (int) Math.pow(10, 12);
        double next = f(u,b);
        for (int i = 1; i < 513; i++) {
            u=next;
            next=f(u,b);
        }
       double result = u+next;
       NumberFormat formatter = new DecimalFormat("#0.000000000"); 
        System.out.println(formatter.format(result));
    }
}

