

/**
 *
 * @author thaycacac
 */
public class Main implements IVisitable {

    public static void main(String[] args) {
        Stack<Student> stack = new Stack<>(new Main());
        stack.push(new Student(1, "Hoa"));
        stack.push(new Student(2, "Hiep"));
        stack.push(new Student(3, "Thuy"));

        stack.traverse();

    }

    @Override
    public void visit(Object obj) {
        Student s = (Student) obj;
        System.out.println(s.toString());
    }

}
