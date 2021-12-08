/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class Manager {

    GetData getData = new GetData();

    void DisplayMenu() {
        System.out.println("=====Calculator program====");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    int[][] getMatrix1() {
        int row = getData.getInt("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        int column = getData.getInt("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][column];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < column; j++) {
                String message = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix[i][j] = getData.getMatrix(message);
            }
        }
        return matrix;
    }

    int[][] getMatrix2(int[][] matrix1, int choice) {
        int[][] matrix2 = null;
        int rowM1 = matrix1.length;
        int colM1 = matrix1[0].length;
        int rowM2, colM2;
        if (choice == 3) {
            do {
                rowM2 = getData.getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check row of matrix2 equal or not column of matrix 1
                if (rowM2 != colM1) {
                    System.out.println("Row matrix 2 must be equal column matrix 1");
                    continue;
                }
                colM2 = getData.getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                break;
            } while (true);
        } else {
            do {
                rowM2 = getData.getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check row of matrix2 equal or not row of matrix 1
                if (rowM2 != rowM1) {
                    System.out.println("Row matrix 2 must be equal row matrix 1");
                    continue;
                } else {
                    break;
                }
            } while (true);
            
            do{
                colM2 = getData.getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                //check column of matrix2 equal or not column of matrix 1
                if (colM2 != colM1) {
                    System.out.println("Column matrix 2 must be equal column matrix 1");
                    continue;
                } else {
                    break;
                }
            }while(true);
        }
        
        matrix2 = new int[rowM2][colM2];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < rowM2; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < colM2; j++) {
                String message = String.format("Enter Matrix2" + "[%d][%d]:", i + 1, j + 1);
                matrix2[i][j] = getData.getMatrix(message);
            }
        }
        return matrix2;
    }

    void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < col; j++) {
                System.out.format("[%d]", matrix[i][j]);
            }
            System.out.println();
        }
    }

    void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        System.out.println("------- Result ----------");
        displayMatrix(matrix1);
        switch(choice){
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    void displayAddition(){
        System.out.println("--------- Addition ------------");
    }
    
    void displaySubtraction(){
        System.out.println("--------- Subtraction ------------");
    }
    
    void displayMultiplication(){
        System.out.println("--------- Multiplication ------------");
    }
}
