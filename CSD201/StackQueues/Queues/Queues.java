package Queues;

import LinkList.MyLinkedList;

/**
 *
 * @author THAYCACAC
 */
public class Queues<T> {

    MyLinkedList<T> linkList = new MyLinkedList<>();

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void enqueue(T data) {
        linkList.addToTail(data);
    }

    public void dequeue() {
        linkList.removeHead();
    }

    public T front() {
        return linkList.getHead();
    }

    public int size() {
        return linkList.size();
    }

    public void clear() {
        linkList.clear();
    }

    public void traverse() {
        linkList.traverse();
    }
}
