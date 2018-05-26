
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student s1, s2;
        //Xây nhà từ bản thiết kế
        s1 = new Student(); //tạo vùng bộ nhớ cho student
        s1.name = "Mo"; //sử dụng khi chưa để private
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
        //1. cho k là số kỳ học nhập từ bàn phím. in ra tất cả sinh viên có kỳ học bằng k
        int k;
        System.out.println("Enter k = ");
        k = in.nextInt();
        for (Student x : students) {//với mỗi sinh viên x nằm trong nhóm sinh viên đã có
            if (x.semester == k) {
                x.intro();
            }
        }
    }
}
