package game_server;

public class CheckWin {

    private int size;
    private final int equal;
    private String[] status;

    public CheckWin() {
        this.size = 0;
        this.equal = 5;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public void setSizeAndStatus(String[] sta) {
        this.size = (int) Math.sqrt(sta.length);
        this.status = sta;
    }

    public boolean checkDraw() {
        int count = 0;
        for (String sta : status) {
            if (sta.equals("*")) {
                count++;
            }
        }
        return count == 0;
    }

    public boolean checkDiagonalRight(int index, String you) {
        int count = 1;
        int step = size + 1;
        for (int i = index + step; i < size * size; i += step) {
            if (i % size == 0) {
                break;
            }
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        for (int i = index - step; i >= 0; i -= step) {
            if (i % size == size - 1) {
                break;
            }
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        System.out.println("DiaRight: " + count);
        return count >= equal;
    }

    public boolean checkDiagonalLeft(int index, String you) {
        int count = 1;
        int step = size - 1;
        for (int i = index + step; i < size * size; i += step) {
            if (i % size == size - 1) {
                break;
            }
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        for (int i = index - step; i >= 0; i -= step) {
            if (i % size == 0) {
                break;
            }
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        System.out.println("DiaLeft: " + count);
        return count >= equal;
    }

    public boolean checkColumn(int index, String you) {
        int count = 1;
        for (int i = index + size; i < size * size; i += size) {
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        for (int i = index - size; i >= 0; i -= size) {
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        System.out.println("Column: " + count);
        return count >= equal;
    }

    public boolean checkRow(int index, String you) {
        int count = 1;
        int currColumn = index / size;
        for (int i = index + 1; i < (currColumn + 1) * size; i++) {
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        for (int i = index - 1; i >= currColumn * size; i--) {
            if (status[i].equals(you)) {
                count++;
            } else {
                break;
            }
        }
        System.out.println("Row: " + count);
        return count >= equal;
    }

}
