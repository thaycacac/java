

/**
 *
 * @author THAYCACAC
 */
public class Queues<T> {

    MyNode<T> head, tail;
    IVisitable visitor;

    public Queues(IVisitable visitor) {
        this.visitor = visitor;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data) {
        MyNode<T> n = new MyNode<>();
        n.setData(data);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public void dequeue() {
        head = head.getNext();
    }

    public T front() {
        return (T) head.getData();
    }

    public int size() {
        MyNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void clear() {
        head = tail = null;
    }

    public void traverse() {
        MyNode<T> temp = head;
        while (temp != null) {
            if (visitor != null) {
                visitor.visit(temp.getData());
            }
            temp = temp.getNext();
        }
    }
}
