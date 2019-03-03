
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student s1, s2;
        // Khởi tạo ra một học sinh
        s1 = new Student(); // Tạo vùng bộ nhớ cho student
        s1.name = "Mo"; // Sử dụng khi chưa để private
        s1.semester = 2;

        s1.intro();

        s2 = new Student();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student name: ");
        s2.name = in.nextLine();
        System.out.print("Enter student semster: ");
        s2.semester = Integer.valueOf(in.nextLine());

        s2.intro();

        //tạo một mảng các sinh viên
        Student[] students = new Student[2];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.print("Enter student name: ");
            students[i].name = in.nextLine();
            System.out.print("Enter student semster: ");
            students[i].semester = Integer.valueOf(in.nextLine());
        }

        //Bài tập: cho k là số kỳ học nhập từ bàn phím. in ra tất cả sinh viên có kỳ học bằng k
        int k;
        System.out.println("Enter k = ");
        k = in.nextInt();
        for (Student x : students) { // Với mỗi sinh viên x nằm trong nhóm sinh viên đã có
            if (x.semester == k) {
                x.intro();
            }
        }
    }
}
