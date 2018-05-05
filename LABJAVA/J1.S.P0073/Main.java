
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final String DATE_VALID = "^\\d{1}|[0-3]{1}\\d{1}-[a-zA-Z]{3}-\\d{4}$";

    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                if (result.matches(DATE_VALID)) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Re-input");
            } else {
                return result;
            }

        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static void addExpense(ArrayList<Expenses> le, int id) {
        System.out.print("Enter Date: ");
        String date = checkInputDate();
        System.out.print("Enter Amount: ");
        double amount = checkInputDouble();
        System.out.print("Enter Content: ");
        String content = checkInputString();
        le.add(new Expenses(id, date, amount, content));
    }

    private static void displayExpense(ArrayList<Expenses> le) {
        if (le.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId(), le.get(i).getDate(),
                    le.get(i).getAmount(), le.get(i).getContent());
            total += le.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    private static int checkIdExist(ArrayList<Expenses> le, int id) {
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private static void deleteExpense(ArrayList<Expenses> le) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        int checkIdExist = checkIdExist(le, id);
        if (checkIdExist != -1) {
            le.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < le.size(); i++) {
                le.get(i).setId(le.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    private static void display() {
        ArrayList<Expenses> le = new ArrayList<>();
        int id = 0;
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addExpense(le, ++id);
                    break;
                case 2:
                    displayExpense(le);
                    break;
                case 3:
                    deleteExpense(le);
                    id--;
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
