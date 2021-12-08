
import java.util.List;

public class Display {

    private final String horizontalLine = " ========== ";
    private final String spaceDot = "   *   ";
    private final String dash = " ---------- ";

    public void menu() {
        System.out.println(horizontalLine + "File Processing" + horizontalLine);
        System.out.print(spaceDot + "1. File person info\n" + spaceDot + "2. Copy text to new file\n" + spaceDot
                + "3. Exit\n" + "> choose: ");
    }

    public void personInfo() {
        System.out.println(dash + "Person Info" + dash);
    }

    public void copyText() {
        System.out.println(dash + "Copy text" + dash);

    }

    public void showList(List<Person> personList) {
        System.out.println(dash + "Resulst" + dash);
        String title = String.format("%-30s%-20s%s", "Name", "Address", "Money");
        System.out.println(title);

        String info;
        for (Person p : personList) {
            info = String.format("%-30s%-20s%s", p.getName(), p.getAddress(), p.getSalary());
            System.out.println(info);
        }

        showLeastAndMostAmount(personList);
    }

    public void showLeastAndMostAmount(List<Person> personList) {
        double min = personList.get(0).getSalary();
        double max = min;
        Person personWithMinSalary = personList.get(0);
        Person personWithMaxSalary = personWithMinSalary;

        for (Person p : personList) {
            if (p.getSalary() < min) {
                personWithMinSalary = p;
                min = p.getSalary();
            } else if (p.getSalary() > max) {
                personWithMaxSalary = p;
                max = p.getSalary();
            }
        }

        System.out.println("\nMin: " + personWithMinSalary.getName() + "\n" + "Max: " + personWithMaxSalary.getName());
    }
}
