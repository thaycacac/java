/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix.operator;

import Matrix.Matrix;
import Matrix.MatrixBinaryOperator;

/**
 *
 * @author hailiang194
 */
public class Multiplication extends MatrixBinaryOperator {

    @Override
    public boolean isOperable(Matrix m1, Matrix m2) {
        return (m1.getColumn() == m2.getRow());
    }

    @Override
    public Matrix compute(Matrix m1, Matrix m2) {
        Matrix matrix = new Matrix(m1.getRow(), m2.getColumn());

        for (int m_r = 0; m_r < m1.getRow(); ++m_r) {
            for (int m_c = 0; m_c < m2.getColumn(); ++m_c) {
                double value = 0.0;
                for (int c = 0; c < m1.getColumn(); ++c) {
                    value += (m1.getValueAt(m_r, c) * m2.getValueAt(c, m_c));
                }
                matrix.setValueAt(m_r, m_c, value);
            }
        }

        return matrix;
    }

}
