
public class Main2 {

    public static void main(String[] args) {
        Student s1 = new Student("An", 2);
        // Khi chưa có contructor đc dùng hàm mặc định nhưng khi có contructor thì không được dùng hàm mặc định
        s1.setName(s1.getName().toUpperCase());
        System.out.println("Name = " + s1.getName());//An
        System.out.println("Semester = " + s1.getName());//2
    }
}
