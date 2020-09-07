/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Matrix.Matrix;
import Matrix.MatrixBinaryOperator;

/**
 *
 * @author hailiang194
 */
public class OperationForm extends Form {
    
    protected String title;
    protected char sign;
    protected MatrixBinaryOperator operator;

    public OperationForm(String title, char sign, MatrixBinaryOperator operator) {
        this.title = title;
        this.sign = sign;
        this.operator = operator;
    }

    @Override
    public void setup() {

    }

    @Override
    protected EXIT_STATUS update() {

        System.out.println(this.title);
        Matrix m1 = Input.inputInitalizeMatrix("Enter matrix m1:");
        Input.inputMatrixValues(m1);

        Matrix m2 = Input.inputInitalizeMatrix("Enter matrix m2:");
        
        if (!this.operator.isOperable(m1, m2)) {
            System.out.println("Can't compute " + m1.getSizeInString() + " " + this.sign + " " + m2.getSizeInString());
            return EXIT_STATUS.LOOP_EXIT;
        }
        Input.inputMatrixValues(m2);
        
        
        System.out.println("------------- Result -----------");
        System.out.println(m1);
        System.out.println(this.sign);
        System.out.println(m2);
        System.out.println("=");
        System.out.println(this.operator.compute(m1, m2));

        return EXIT_STATUS.LOOP_EXIT;
    }

}
