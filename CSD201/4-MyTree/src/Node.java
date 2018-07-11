
public class Node {
    
    int info;
    Node left, right;

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public Node(int info) {
        this(info,null,null);
    }
}
