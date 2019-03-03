
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Main0 {

    private static final Scanner in = new Scanner(System.in);

    //check user input a number integer
    private static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }
//allow user input number of array

    private static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }
    //allow user input value of array

    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = checkInputInt();
        }
        return a;
    }

    //sort array by bubble sort
    private static void sortArrayByInsectionSort(int[] a) {
        int len = a.length;
        System.out.print("Unsorted array: ");
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println();
    }

    //display array after sort
    private static void print(int[] a) {
        System.out.print("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = inputValueOfArray(n);
        sortArrayByInsectionSort(a);
        print(a);
    }

    // 7 -5 2 16 4
    // -5 7 2 16 4
    // -5 2 7 16 4
    // -5 2 7 16 4
    // -5 2 7 4 16
    //...
}
