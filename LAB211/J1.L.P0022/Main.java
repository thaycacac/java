
import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        //loop until user want to exit
//        candidates.add(new Experience(99, "code", "1", "Pham Ngoc", "Hoa", 1991,
//                "Ninh Binh", "0968038714", "hoapnse05740", 0));
//        candidates.add(new Fresher("2000", "good", "2", "Đo Quang", "Hiep",
//                1995, "Ha Noi", "0984481349", "thaycacac@gmail.com", 1));
//        candidates.add(new Internship("PRJ311", "Spring", "FPT University",
//                "2", "Nguyen Xuan", "Cuong", 2018, "Ha Noi", "0986246813",
//                "thaycacacoficial@gmail.com", 2));
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createCandidate(candidates, 0);
                    break;
                case 2:
                    Manager.createCandidate(candidates, 1);
                    break;
                case 3:
                    Manager.createCandidate(candidates, 2);
                    break;
                case 4:
                    Manager.searchCandidate(candidates);
                    break;
                case 5:
                    return;
            }
        }
    }
}
