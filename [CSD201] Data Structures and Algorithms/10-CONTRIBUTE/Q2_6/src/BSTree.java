/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================

    /*
    void insert(string xOwner, int xPrice) - check if xOwner.charAt(0) = ‘B' or xPrice > 100
    then do nothing, otherwise insert new car with owner=xOwner, price=xPrice to the tree.

    void f1() - You do not need to edit this function. Your task is to complete the insert(...)
    function above only. Output in the file f1.txt must be the following:
    (A,5) (C,2) (E,4) (G,3) (D,6) (F,7)
    (C,2) (G,3) (E,4) (A.5) (D,6) (F,7)
    */
    
    void insert(String xMaker, int xType, int xRadius) {
        //You should insert here statements to complete this function
        if (xMaker.charAt(0) == 'B' || xType < 0 || xRadius < 0) {
            return;
        }
        Ball ball = new Ball(xMaker, xType, xRadius);
        Node node = new Node(ball);

        if (isEmpty()) {
            root = node;
            return;
        }
        Node cu = root;
        Node father = null;
        while (cu != null) {
            if (cu.info.type == xType) {
                return;
            }
            father = cu;
            if (cu.info.type < xType) {
                cu = cu.right;
            } else {
                cu = cu.left;
            }
        }
        if (father.info.type < xType) {
            father.right = node;
        } else {
            father.left = node;
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    
    /*
    void f2() — Perform pre-order traversal from the root but display to file f2.txt nodes having
    price in the interval [3,5] only. Hint: Copy the function preOrder(...) to preOrder2(...) and
    modify it. Output in the file f2.txt must be the following:
    (C,6) (D,2) (F,4) (H,3) (I,5) (E,8) (G,7)
    (F,4) (H,3) (I,5)
    */
    
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        
        postOrder2(root, f);

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if (p.info.radius < 5) {
            fvisit(p, f);
        }
    }

//=============================================================
    
    /*
    void f3() — Perform breadth-first traversal from the root and delete by copying the first node
    having both 2 sons and price < 7. Output in the file £3.txt must be the following.
    (C,8) (D,6) (E,9) (F,2) (G,7) (H,1) (I,3) (J,5)(K,4)
    (C,8) (J,5) (E,9) (F,2) (G,7) (H,1) (I,3) (K,4)
    */
    
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        inOrderF3(root, f);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    void inOrderF3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF3(p.left, f);
        if (p.left != null && p.right != null && p != root) {
            deleteByCopying(p);
            return;
        }
        inOrderF3(p.right, f);
    }
    
    void deleteByCopying(Node p) { // copy left
        if (p == null || p.left == null) {
            return;
        }
        if (p.left.right == null) {
            p.info = p.left.info;
            p.left = p.left.left;
        } else {
            Node father = p.left;
            Node cur = p.left.right;
            while (cur.right != null) {
                father = cur;
                cur = cur.right;
            }
            p.info = cur.info;
            father.right = cur.left;
        }
    }

//=============================================================
    
    /*
    void f4() - Perform breadth-first traversal from the root and find the first node p having left
    son and price < 7. Rotate p to right about its’ left son. Output in the file M.txt must be the
    following:
    (C,8) (D,6) (E,9) (F,2) (G,7) (H,1) (I,3) (J,5) (K,4)
    (C,8) (F,2) (E,9) (H,1) (D,6) (I,3) (G,7) (J,5) (K,4)
    */
    
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        inOrderF4(root, f);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    private Node getParent(Node n) {
        if (n == root) {
            return null;
        }
        Node father = null;
        Node cur = root;
        while (cur != null && cur.info.type != n.info.type) {
            father = cur;
            if (cur.info.type < n.info.type) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return father;
    }

    void leftRotate(Node p) {
        Node grandpa = getParent(p);
        Node child;
        if (p == null || p.right == null) {
            return;
        } else {
            child = p.right;
            p.right = child.left;
            child.left = p;
        }
        if (grandpa != null) {
            if (grandpa.info.type < p.info.type) {
                grandpa.right = child;
            } else {
                grandpa.left = child;
            }
        } else {
            root = child;
        }
    }

    void inOrderF4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrderF4(p.left, f);
        if (p.left != null && p.right != null && p != root) {
            leftRotate(p);
        }
        inOrderF4(p.right, f);
    }

}
