
import java.io.Serializable;


public class Student implements Serializable{

    private String name;
    private int semester;

    public Student(String name, int semester) {
        this.name = name;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return name + "\t" + semester;
    }

}
