
import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList<>();
        Validation validation = new Validation();
        ls.add(new Student("1", "Pham Ngoc Hoa", "Spring", "java"));
        ls.add(new Student("2", "Do Quang Hiep", "Summer", ".net"));
        ls.add(new Student("3", "Nguyen Xuan Cuong", "Spring", "c/c++"));
        //loop until user want to exit program
        while (true) {
            //Show menu option
            Manager.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    Manager.createStudent(ls);
                    break;
                case 2:
                    Manager.findAndSort(ls);
                    break;
                case 3:
                    Manager.updateOrDelete(ls);
                    break;
                case 4:
                    Manager.report(ls);
                    break;
                case 5:
                    return;
            }
        }
    }

}
