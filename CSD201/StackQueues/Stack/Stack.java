package Queues;

import LinkList.MyLinkedList;

/**
 *
 * @author THAYCACAC
 */
public class Stack<T> {

    MyLinkedList<T> linkList = new MyLinkedList<>();

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void push(T data) {
        linkList.addToTail(data);
    }

    public T pop() {
        T t = linkList.getTail();
        linkList.removeTail();
        return t;
    }

    public int size() {
        return linkList.size();
    }

    public T top() {
        return linkList.getTail();
    }

    public void clear() {
        linkList.clear();
    }

    public void traverse() {
        linkList.traverse();
    }
}
