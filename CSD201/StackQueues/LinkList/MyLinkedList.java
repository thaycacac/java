package LinkList;

/**
 *
 * @author sonnt
 */
public class MyLinkedList<T> {

    MyNode<T> head, tail;

    public MyLinkedList() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToTail(T data) {
        MyNode<T> n = new MyNode<>();
        n.setData(data);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public void addToHead(T data) {
        MyNode n = new MyNode();
        n.setData(data);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    public void addToIndex(T data, int index) {
        if (index == 0) {
            addToHead(data);
        } else {
            MyNode n = new MyNode();
            n.setData(data);
            MyNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            MyNode temp2 = temp.getNext();
            n.setNext(temp2);
            temp.setNext(n);
        }
    }

    public void removeTail() {
        MyNode temp = head;
        for (int i = 0; i < (size() - 2); i++) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        tail = temp;
    }

    public void removeHead() {
        head = head.getNext();
    }

    public void removeIndex(int index) {
        if (index == 0) {
            removeHead();
        } else {
            MyNode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            MyNode temp2 = temp.getNext();
            MyNode temp3 = temp2.getNext();
            temp.setNext(temp3);
        }
    }

    public T getTail() {
        MyNode temp = head;
        for (int i = 0; i < size() - 1; i++) {
            temp = temp.getNext();
        }
        return (T) temp.getData();
    }
    
    public T getHead() {
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
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
