/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class Calculator {

    int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < col; j++) {
                result[i][j]= matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < col; j++) {
                result[i][j]= matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int rowM1 = matrix1.length;
        int rowM2 = matrix2.length;
        int colM2 = matrix2[0].length;
        int[][] result = new int[rowM1][colM2];
        //traverse from first element of row to last element of row of matrix 1
        for (int i = 0; i < rowM1; i++) {
            //traverse from first element of column to last element of column of matrix 2
            for (int j = 0; j < colM2; j++) {
                //traverse from first element of row to last element of row of matrix 1
                for (int k = 0; k < rowM2; k++) {
                    result[i][j] += matrix2[k][j] * matrix1[i][k];
                }
            }
        }
        return result;
    }
    
}
