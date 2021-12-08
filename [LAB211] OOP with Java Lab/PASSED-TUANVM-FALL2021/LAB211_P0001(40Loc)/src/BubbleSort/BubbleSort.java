/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BubbleSort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        //1. User enter a positive number decimal
        int size_array = InputPositiveNumber("Enter number of array:");
        //2. Create array by generate random integer in range
        int[] array = CreateArray(size_array);
        boolean test = false;
//        int[] array = {5, 1, 12, -5, 16};// test case
//        boolean test = true;
        //3. Display before sort
        Display(array, "Unsorted array: ");
        //4. Sort by Bubble sort
        BubbleSort(array, test);
        //5. Display after sort
        Display(array, "Sorted array: ");
    }

    private static int InputPositiveNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a positive integer number");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                //check value of size must be a positive number
                if (size_array <= 0) {
                    throw new Exception();
                }
                //Compare float value of input with size_array catch input be a rational number
                if ((int) size_array != size_array) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input could not be a string. Please enter a positive integer number");
                continue;
            } catch (Exception NegaError) {
                System.out.println("Input could not be less than zero. Please enter a positive integer number");
                continue;
            } catch (Error RealNumError) {
                System.out.println("Input could not be a real number. Please enter a positive integer number");
                continue;
            }
        } while (true);
        return (int) size_array;
    }

    private static int[] CreateArray(int size_array) {
        int[] array = new int[size_array];
        Random rd = new Random();
        //Loop use to random each element of array
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }

    private static void Display(int[] array, String msg) {
        System.out.print(msg);
        System.out.print("[");
        //Loop use to accessed each element of array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //Check index to Display comma
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        if(msg.equals("Unsorted array: ")){
            System.out.println("]");
        }else{
            System.out.print("]");
        }
    }

    private static void BubbleSort(int[] array, boolean test) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    //Display each step in sorting process in test case
                    if (test == true) {
                        Display(array, "");
                        System.out.println("    " + array[j] + ">" + array[j + 1] + ", " + "swap");//test algorithm
                    }
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (test == true) { //Display each step in sorting process in test case
                    Display(array, "");//testalgorithm
                    System.out.println("    " + array[j] + "<" + array[j + 1] + ", " + "ok");
                }
            }
        }
    }

    
}
