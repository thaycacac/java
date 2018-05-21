

/**
 *
 * @author THAYCACAC
 */
public class Stack<T> {

    MyNode<T> head, tail;
    IVisitable visitor;

    public Stack(IVisitable visitor) {
        this.visitor = visitor;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T data) {
        MyNode<T> n = new MyNode<>();
        n.setData(data);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public T pop() {
        MyNode temp = head;
        for (int i = 0; i < size() - 1; i++) {
            temp = temp.getNext();
        }
        return (T) temp.getData();
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

    public void top() {
        MyNode temp = head;
        for (int i = 0; i < (size() - 2); i++) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        tail = temp;
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
