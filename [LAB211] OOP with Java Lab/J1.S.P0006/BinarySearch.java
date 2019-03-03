package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter search value:");
        int search = scanner.nextInt();
        
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        BinarySearch searcher = new BinarySearch();
        searcher.bubbleSort(array);
        
        System.out.print("Sorted array: ");
        searcher.displayArray(array);
        
        int foundIndex = searcher.binarySearch(array, search, 0, length - 1);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
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
    
    /**
     *
     * @param arr the array
     */
    public void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * searches for a value in sorted array
     *
     * @param array array to search in
     * @param value searched value
     * @param left index of left boundary
     * @param right index of right boundary
     * @return position of searched value, if it presents in the array or -1, if
     * it is absent
     */
    int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }
}
