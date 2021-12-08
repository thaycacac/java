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
public class Matrix {
    
    private int row;
    private int column;
    private double[] values;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.values = new double[this.row * this.column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * set new value for matrix[r, c]
     *
     * @param r row index
     * @param c column index
     * @param value new value
     */
    public void setValueAt(int r, int c, double value) {
        this.values[r * this.column + c] = value;
    }

    /**
     * get value matrix[r, c]
     * @param r row index
     * @param c column index
     * @return value of matrix[r, c]
     */
    public double getValueAt(int r, int c) {
        return this.values[r * this.column + c];
    }
    
    
    public String getSizeInString()
    {
        return "(" + this.row + " x " + this.column + ")";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        for (int r = 0; r < this.row; ++r) {
            for (int c = 0; c < this.column; ++c) {
                builder.append("[" + this.getValueAt(r, c) + "]");
            }
            builder.append('\n');
        }
        
        return builder.toString();
    }
    
    
}
