
public class Student {

    //data
    private String name;
    private int semester;
    private boolean active;
    //method
    void login() {

    }

    void intro() {
        System.out.printf("%-20s%-10d\n", name, semester);
    }

    //contructor = ctor
    // name == name of class
    // not return
//    Student(String x, int y){
//        name = x;
//        semester = y;
//    }
    public Student(String name, int semester) {
        this.name = name;
        this.semester = semester;
    }

    //Tên giống nhau nhưng java hiểu là khác nhau - overload methods => tính đa hình
    public Student() {
        name = "";
        semester = 1;
    }

    //add method
    //mutator/getter
    public String getName() {
        return name;
    }
    //trường hợp đặc biệt thay get bằng is nếu trả về boolean
    public boolean isActive(){
        return active;
    }

    //accessor/setter
    public void setName(String name) {
        this.name = name;
    }
    //auto add getter setter
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
}
