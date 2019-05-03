
import java.util.ArrayList;
import java.util.Collections;//chuyên xử lý mảng
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IProject p = new MyProject(); //tập hợp các chức năng
        // MyProject p = new MyProject();//không vì có thể thêm các method mà ở 
        // MyProject có mà không khai báo ở interface
        p.addProject(new Project(2017, "CMS", "FPTU"));
        p.addProject(new Project(2016, "Uniap", "FUGHL"));
        p.addProject(new Project(2015, "eTicket", "FPT-HCM"));
        p.print();
        //list all project which was started in 2016
        System.out.println("List of project started in 2016");
        p.listProjectByYear(2016);
        //sort by year
        p.sortByStarted();
        p.print();
        //sort by Name
        p.sortByName();
        p.print();



       List<String> s = new ArrayList<>();//good
       s = new ArrayList<>();//so so
       s = new ArrayList<String>();//bad
       s.add("xin chao");
       s.add("chao");
       s.add("hello");
       s.add("ciao");
       Collections.sort(s);
       System.out.println(s);
       System.out.println("Min = " + Collections.min(s));
       Collections.reverse(s);
       System.out.println(s);
       Collections.swap(s, 0, 2);
       System.out.println(s);
    }
}
