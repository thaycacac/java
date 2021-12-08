
public class Main {

    static final String[] space = {" ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           "};

    public static String printSquare(int min, int max) {
        // constants
        final String first = "| ";
        final String last = " |";
        final String horizontal = "---------------";

        int distance = max - min;

        StringBuffer sequence = new StringBuffer("");
        String rs = horizontal + "\n";

        System.out.println("printSquare(" + min + "," + max + ")");

        while (min <= max) {
            sequence.append(min++);
        }

        if (distance >= 0) {
            rs += first + sequence + space[9 - distance] + last + "\n";

            for (int i = 1; i <= distance; i++) {
                sequence.append(sequence.charAt(0));
                sequence.deleteCharAt(0);
                rs += first + sequence + space[9 - distance] + last + "\n";
            }
        }

        while (distance < 9) {
            rs += first + space[10] + last + "\n";
            distance++;
        }

        rs += horizontal;

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(printSquare(0, 9));
        System.out.println(printSquare(2, 8));
        System.out.println(printSquare(7, 7));
        System.out.println(printSquare(8, 6));
    }
}
