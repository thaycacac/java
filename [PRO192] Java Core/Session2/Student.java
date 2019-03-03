
public class Student {

    // Data
    private String name;
    private int semester;
    private boolean active;

    // Method
    void login() {

    }

    void intro() {
        System.out.printf("%-20s%-10d\n", name, semester);
    }

    public Student(String name, int semester) {
        this.name = name;
        this.semester = semester;
    }

    // Tên giống nhau nhưng java hiểu là khác nhau - overload methods => tính đa hình
    public Student() {
        name = "";
        semester = 1;
    }

    // Mutator/getter
    public String getName() {
        return name;
    }
    // Thay get bằng is nếu trả về boolean
    public boolean isActive(){
        return active;
    }

    // Accessor/setter
    public void setName(String name) {
        this.name = name;
    }
    // Auto add getter setter
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
}
