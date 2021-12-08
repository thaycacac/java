/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix.operator;

import Matrix.*;

/**
 *
 * @author hailiang194
 */
public class Subtraction extends MatrixBinaryOperator {

    @Override
    public boolean isOperable(Matrix m1, Matrix m2) {
        return ((m1.getRow() == m2.getRow()) && (m1.getColumn() == m2.getColumn()));
    }

    @Override
    public Matrix compute(Matrix m1, Matrix m2) {
        Matrix matrix = new Matrix(m1.getRow(), m2.getColumn());

        for (int r = 0; r < m1.getRow(); ++r) {
            for (int c = 0; c < m1.getColumn(); ++c) {
                double value = m1.getValueAt(r, c) - m2.getValueAt(r, c);
                matrix.setValueAt(r, c, value);
            }
        }

        return matrix;
    }

}
