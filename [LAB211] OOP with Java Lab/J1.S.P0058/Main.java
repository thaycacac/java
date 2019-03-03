package Thaycacac;

import java.util.HashMap;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addNewWord(hm);
                    break;
                case 2:
                    Manager.deleteWord(hm);
                    break;
                case 3:
                    Manager.translate(hm);
                    break;
                case 4:
                    return;
            }
        }
    }
}
