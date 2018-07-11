
public class BSTree {
    
    Node root;

    public BSTree() {root = null;}
    
    public boolean isEmpty() {return root == null;}
    
    public void visit(Node p) 
    {if(p == null) return;
     System.out.print(p.info + "  ");
    }
    //return a Node which has key = given key in the tree p
    public Node search(Node p, int key) 
    {if(p == null) return null;
     if(p.info == key) return p;
     else if(p.info > key) return search(p.left, key);
     else return search(p.right, key);
    }
    //insert a key x to the tree
    public void insert(int x) 
    {Node p = new Node(x);
     Node f = null, q = root;
     while(q != null) {
      if(q.info == x) {System.out.println("Key cannot be duplicated...");return;}
      if(q.info < x) {f = q; q = q.right;}
      else {f = q; q = q.left;}
     }
    if(f == null) root = p;
    else if(p.info > f.info) f.right = p;
    else f.left = p;
    }
    //preorder a tree
    public void preOrder(Node p) {
     if(p == null) return;
     visit(p);
     preOrder(p.left);
     preOrder(p.right);
    }
    //postorder a tree
    public void postOrder(Node p) {
     if(p == null) return;
     postOrder(p.left);postOrder(p.right);visit(p);
    }
    //inorder a tree
    public void inOrder(Node p) {
     if(p == null) return;
     inOrder(p.left);visit(p);inOrder(p.right);
    }
    //bft
    public void BFT(Node p)
    {if(p == null) return;
     MyQueue m = new MyQueue();
     m.enqueue(p);
     while(!m.isEmpty()) {
      Node q = (Node)m.dequeue();
      visit(q);
      if(q.left != null) m.enqueue(q.left);
       if(q.right != null) m.enqueue(q.right);
     }
    }
    //height of tree
    int height(Node p)
    {if(p==null) {return 0;}
    else{int lDepth=height(p.left);//compute the depth of each subtree
    int rDepth=height(p.right);
    if (lDepth > rDepth) return (lDepth + 1);//use the larger one
    else return (rDepth + 1);
    }}
}
