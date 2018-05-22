package Queues;

import LinkList.Student;

/**
 *
 * @author thaycacac
 */
public class MainQueues {

    public static void main(String[] args) {
        Queues<Student> queues = new Queues<>();
        queues.enqueue(new Student(1, "Hoa"));
        queues.enqueue(new Student(2, "Hiep"));
        queues.enqueue(new Student(3, "Thuy"));
        queues.traverse();
    }
}
