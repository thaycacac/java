/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Validation check = new Validation();
        ExpenseList handyExpense = new ExpenseList();
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            int option = check.inputInt("Your choice: ", 1, 4);
            switch (option) {
                case 1:
                    handyExpense.addExpense();
                    break;
                case 2:
                    handyExpense.display();
                    break;
                case 3:
                    handyExpense.removeExpense();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
