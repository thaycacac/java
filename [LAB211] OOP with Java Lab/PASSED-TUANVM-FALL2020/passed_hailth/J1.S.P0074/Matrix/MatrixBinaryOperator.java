/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author hailiang194
 */
public abstract class MatrixBinaryOperator {

    /**
     * check if first matrix can do the operator with second matrix
     *
     * @param m1 first matrix
     * @param m2 second matrix
     * @return true if 2 matrix can operate, otherwise false
     */
    public abstract boolean isOperable(Matrix m1, Matrix m2);

    /**
     * operate 2 matrix without checking
     *
     * @param m1 first matrix
     * @param m2 second matrix
     * @return the result of operation of 2 matrix
     */
    public abstract Matrix compute(Matrix m1, Matrix m2);

    private String unOperatableMessage(Matrix m1, Matrix m2) {
        return "Unablue to operate " + m1.getSizeInString() + "and " + m2.getSizeInString();
    }

    /**
     * operate 2 matrix with checking
     *
     * @param m1 first matrix
     * @param m2 second matrix
     * @return the result of operation of 2 matrix
     * @throws Exception when 2 matrix is not operaable
     */
    public Matrix operate(Matrix m1, Matrix m2) throws Exception {
        if (!this.isOperable(m1, m2)) {
            throw new Exception(this.unOperatableMessage(m1, m2));
        }
        
        return this.compute(m1, m2);
    }
}
