import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);        
        
        System.out.print("Enter Client Name: ");
        String name = sc.nextLine();
        Client customer = new Client(name);           
        boolean check = true;

        FilteredAccount acc = new FilteredAccount(customer);

        while (check) {
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            System.out.print("Enter approved status: ");
            boolean approved = sc.nextBoolean();
            Transaction a = new Transaction(value, approved);
            acc.add(a);
            System.out.print("Do you want to continue input: ");
            check = sc.nextBoolean();
        }
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println(acc.getCustomer());  
        for (Transaction s: acc.getList()) {
            System.out.println("Transaction:\t" + s.getValue() + ", Approved Status: " + acc.process(s));       
        }

        System.out.println("--------------------------------------------------------------------"); 
        System.out.println("Percentage of Approved Transaction, value less or equal 0: " + df.format(acc.percentFiltered()) + "%");
    }
}
