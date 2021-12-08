

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Manager manager = new Manager();
        GetData getData = new GetData();
        int choice;
        do{
            //1.Display menu
            manager.DisplayMenu();
            //2.Get user data
            choice = getData.getInt("Your choice: ", 1, 4);
            //Perform function based on select option
            switch(choice){
                //Option 1: Addition matrixes
                case 1:
                    manager.displayAddition();
                    //input matrix 1
                    int[][] matrix1 = manager.getMatrix1();
                    //input matrix 2
                    int[][] matrix2 = manager.getMatrix2(matrix1, choice);
                    //add 2 matrix: matrix 1 and matrix 2
                    int[][] result = calculator.additionMatrix(matrix1, matrix2);
                    //display result
                    manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                //Option 2: Subtraction matrixes
                case 2:
                    manager.displaySubtraction();
                    //input matrix 1
                    matrix1 = manager.getMatrix1();
                    //input matrix 2
                    matrix2 = manager.getMatrix2(matrix1, choice);
                    //subtraction 2 matrix: matrix 1 to matrix 2
                    result = calculator.subtractionMatrix(matrix1, matrix2);
                    //display result
                    manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                //Option 3: Multiplication matrixes
                case 3:
                    manager.displayMultiplication();
                    //input matrix 1
                    matrix1 = manager.getMatrix1();
                    //input matrix 2
                    matrix2 = manager.getMatrix2(matrix1, choice);
                    //multiplication 2 matrix: matrix 1 and matrix 2
                    result = calculator.multiplicationMatrix(matrix1, matrix2);
                    //display result
                    manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                //Option 4: Exit program
                case 4:
                    System.exit(0);
                    break;
            }
        }while(true);
    }
}
