
public class Node {
    
    Object info;
    Node next;
    
    Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(Object info) {
        this(info, null);
    }
}
