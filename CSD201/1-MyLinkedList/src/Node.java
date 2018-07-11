
public class Node {
    
    int info; //data of Node
    Node next;
    //create a new Node 
    Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(int info) {
        this(info,null);
    }
}
