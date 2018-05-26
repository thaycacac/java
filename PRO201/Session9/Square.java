package session9;

public class Square implements Comparable<Square> {

    private int width;
    private boolean border;

    public Square() {
    }

    public Square(int width, boolean border) {
        this.width = width;
        this.border = border;
    }

    @Override
    public int compareTo(Square o) {
        if (this.width > o.width) {
            return 1;
        } else if (this.width < o.width) {
            return -1;
        } else {
            if (this.border == o.border) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return width + "\t" + border;
    }

}
