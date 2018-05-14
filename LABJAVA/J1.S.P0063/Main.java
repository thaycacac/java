
import java.util.Scanner;

/**
 *
 * @author thaycacac
 */
class PersonWrapper {

    Person p;

    public PersonWrapper() {
    }

    public PersonWrapper(Person p) {
        this.p = p;
    }
}

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Input must be digit.");
            }
        }
    }

    private static double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result < 0) {
                    System.err.println("Salary is greater than zero");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("You must input digidt.");
                System.out.print("Please input salary: ");
            }
        }
    }

    private static int checkInputNumberStudent() {
        System.out.print("Enter number student: ");
        int n = checkInputInt();
        return n;
    }

    private static Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        System.out.print("Please input address: ");
        String address = checkInputString();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        return new Person(name, address, salary);
    }

    private static void swap(PersonWrapper person1, PersonWrapper person2) {
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }

    private static void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.salary > listPersonWrapper[j].p.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.err.println("Sort sussess.");
        return;
    }

    public static void main(String[] args) {
        int n = checkInputNumberStudent();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        sortBySalary(persons, listPersonWrapper);
        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i].p.displayPersonInfo();
        }
    }
}
