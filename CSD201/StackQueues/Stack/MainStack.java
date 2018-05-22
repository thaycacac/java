package Stack;

import LinkList.Student;

/**
 *
 * @author thaycacac
 */
public class MainStack{

    public static void main(String[] args) {
        Stack<Student> stack = new Stack<>();
        stack.push(new Student(1, "Hoa"));
        stack.push(new Student(2, "Hiep"));
        stack.push(new Student(3, "Thuy"));
        stack.push(new Student(4, "Huyen"));
        stack.traverse();
    }
}
