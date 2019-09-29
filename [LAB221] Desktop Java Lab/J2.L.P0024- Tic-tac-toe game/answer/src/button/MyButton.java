package button;

import javax.swing.JLabel;

public final class MyButton {

    private final int index;
    private final JLabel button;
    private String status;
    private final int row;
    private final int col;

    public MyButton(int index, JLabel button, int row, int col) {
        this.index = index;
        this.button = button;
        this.status = "*";
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getIndex() {
        return index;
    }

    public JLabel getButton() {
        return button;
    }

}
