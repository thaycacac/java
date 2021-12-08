
import java.util.Scanner;

public class Main {

    static Scanner SC = new Scanner(System.in);

    public static int inputInteger(String MSG, int MIN, int MAX) {
        int Ret = 0;
        do {
            System.out.print(MSG);
            try {
                Ret = Integer.parseInt(SC.nextLine());
                if (Ret >= MIN && Ret <= MAX) {
                    break;
                }
                System.out.println("Out of range, please enter a number in range " + MIN + " - " + MAX);
            } catch (NumberFormatException e) {
                System.out.println("In correct input, try again");
            }
        } while (true);
        return Ret;
    }

    public static void main(String[] args) {
        BankingAccount acc = new BankingAccount();
        BankingAccount.Startup s = acc.new Startup(3000);
        MinMaxAccount m = new MinMaxAccount(s);
        do {
            System.out.println("---------Menu--------");
            System.out.println("1. Enter Credit");
            System.out.println("2. Enter Debit");
            System.out.println("3. Show Balance-Max-Min");
            System.out.println("4. Exit");
            System.out.println("Current balance: 3000");
            int option = inputInteger("Enter option:", 1, 4);
            switch (option) {
                case 1:
                    int inputCre = inputInteger("Enter Credit: ", 0, Integer.MAX_VALUE);
                    m.credit(acc.new Credit(inputCre));
                    break;
                case 2:
                    int inputDe = inputInteger("Enter Debit: ", 0, Integer.MAX_VALUE);
                    m.debit(acc.new Debit(inputDe));
                    break;
                case 3:
                    System.out.println("\tBalace: " + m.getBalance());
                    System.out.println("\tMin: " + m.getMin());
                    System.out.println("\tMax: " + m.getMax());
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

}