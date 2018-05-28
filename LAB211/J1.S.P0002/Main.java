
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
    private static void sortArrayBySectionSort(int[] a) {
        int len = a.length;
        System.out.print("Unsorted array: ");
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
             if(i==1) break;
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
        sortArrayBySectionSort(a);
        print(a);
    }

    // 5 1 12 -5 16 2 12 14
    // -5 1 12 5 16 2 12 14
    // -5 1 12 5 16 2 12 14
    //...
}
