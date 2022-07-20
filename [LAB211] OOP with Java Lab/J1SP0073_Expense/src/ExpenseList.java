
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class ExpenseList {

    private List<Expense> list = new ArrayList<>();
    private Validation check = new Validation();

    public void addExpense() {
        int ID;
        if (list.isEmpty()) {
            ID = 1;
        } else {
            ID = list.get(list.size() - 1).getID() + 1;
        }
        String date = check.inputDate("Enter Date: ");
        double amount = check.inputDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        String content = check.inputString("Enter Content: ", "[A-Za-z0-9\\s]+");
        Expense e = new Expense(ID, date, amount, content);
        list.add(e);
        System.out.println("Add new expense successfully");
    }

    public void removeExpense() {
        int ID = check.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (Expense expense:list) {
            if (expense.getID() == ID) {
                list.remove(expense);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("ID does not exist");
    }

    public void display() {
        double total = 0;
        System.out.println(String.format("%-4s%-15s%-15s%-20s", "ID", "Date", "Amount", "Content"));
        for (Expense e : list) {
            System.out.println(e);
            total = total + e.getAmount();
        }
        System.out.println("\t\tTotal: " + total);
    }

}
