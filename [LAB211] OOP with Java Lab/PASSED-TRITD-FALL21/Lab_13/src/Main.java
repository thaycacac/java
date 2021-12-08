
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Enter enter = new Enter();
        Display display = new Display();
        Person person = new Person();
        DataBase data = new DataBase();

        int choose = 0;

        do {
            display.menu();
            try {
                choose = Integer.parseInt(enter.choose());
            } catch (Exception e) {
                // TODO: handle exception
                System.err.println("Can not convert String to int");
            }
            switch (choose) {
                case 1:
                    try {
                        display.personInfo();
                        String path = enter.path("path");
                        Double money = enter.money();
                        List<Person> list = person.getPerson(path, money);
                        display.showList(list);
                    } catch (Exception e) {
                        System.err.println("Wrong file! Enter again!");
                    }
                    break;
                case 2:
//                    try {
//                        display.copyText();
//                        String source = enter.path("source");
//                        String newFileName = enter.path("new file name");
//                        if (data.copyWordOneTimes(source, newFileName)) {
//                            System.out.println("Copy done...");
//                        }
//                    } catch (Exception e) {
//                        System.err.println("Wrong file! Enter again!");
//                    }
                    data.searchWorld();
                    break;
                case 3:
                    System.out.println("Good Bye!!");
                    break;
                default:
                    System.out.println("Invalid number!");
            }
        } while (choose != 3);
    }
}
