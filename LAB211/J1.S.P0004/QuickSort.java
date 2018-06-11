import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        QuickSort sorter = new QuickSort();
        
        System.out.print("Unsorted array: ");
        sorter.displayArray(array);
        
        System.out.println();
        
        sorter.quickSort(array, 0, length - 1);
        System.out.print("Sorted array: ");
        sorter.displayArray(array);
    }

    /**
     *
     * @param arr the array
     */
    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }
}
