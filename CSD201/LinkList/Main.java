package mycustomlinkedlist;

/**
 *
 * @author thaycacac
 */
public class Main implements IVisitable {

    public static void main(String[] args) {
        MyLinkedList<Student> list = new MyLinkedList<>(new Main());
        list.addToTail(new Student(1, "Vinh"));
        list.addToTail(new Student(2, "Long"));
        list.addToTail(new Student(3, "Nam"));
        list.addToTail(new Student(4, "Hiep"));
        list.addToIndex(new Student(5, "Hoang"), 4);
        list.removeIndex(0);

        list.traverse();
        System.out.println("Size: " + list.size());;
    }

    @Override
    public void visit(Object obj) {
        Student s = (Student) obj;
        System.out.println(s.toString());
    }

}
