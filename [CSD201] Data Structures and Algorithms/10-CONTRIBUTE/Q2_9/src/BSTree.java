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
    void insert(String xCode, int xType, it xPrice) - check if xCode.charAt(0) == 'B' then do
    nothing, otherwise insert new com with code = xCode, type = xType, price = xPrice to the tree
    (type and price can get negative value).

    void f1() — Do not cdít this method. Your task is to completc the inscet(...) method above
    only. Output in the file fi.txt must be the following:
    (A,4,2) (C,1,2) (D,5,6) (E,3,4) F,6,7) (G,2,3)
    (C,1,2) (G,2,3) (E,3,4) (A,4,2) (D,5,6) (F,6,7)
    */

    void insert(String xCode, int xType, int xPrice) {
        //You should insert here statements to complete this function
        if (xCode.charAt(0) == 'B') {
            return;
        }
        insert2(new Corn(xCode, xType, xPrice));
    }
    
     void insert2(Corn x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == x.type) {
                return;
            }
            f = p;
            if (x.type < p.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.type < f.info.type) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(2);
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
    void f2() - Perform in-order traversal from the root but đisplay to file f2.txt nodes with
    price < 5 only. Hint: Copy the function inOrder(...) to function inOrder2(...) and modify it.
    Output in the file f2.txt must be the following:
    (D,1,6) (H,2,3) (F,3,8) (I,4,5) (C,5,1) (G,6,2) (E,7,4)
    (H,2,3) (C,5,1) (G,6,2) (E,7,4)
    */

    void f2() throws Exception {
        clear();
        loadData(6);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        inOrder2(root, f);
        
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.info.price < 5) {
            fvisit(p, f);
        }
        inOrder2(p.right, f);
    }

//=============================================================
    /*
    void f3() — Perform pre-order traversal and find the first node p having type < 10, then delete
    p by copying. Output in the file f3.txt must be the following:
    (C,10,4) (D,5,2) (F,3,8) (G,6,12) (H,8,6) (E,12,10)
    (C,10,4) (F,3,8) (G,6,12) (H,8,6) (E,12,10)
    */

    void f3() throws Exception {
        clear();
        loadData(10);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        preOrderAndDelete(root);
        
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    void deleByCopy(int x) {
        if (isEmpty()) {
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == x) {
                break;
            }
            f = p;
            if (x < p.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }      // p is a leaf-node
        if (p.left == null && p.right == null) {
            if (f == null) { // p is the root
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        // p has left son
        if (p.left != null && p.right == null) {
            if (f == null) { // p is the root
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p is the root
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // Start finding the right-most node on the left subtree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp now is the right-most node
            p.info = rp.info;
            // Delete rp;
            if (frp == null) {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }

    }

    void preOrderAndDelete(Node p) {
        if (p == null) {
            return;
        }
        if (p.info.type < 10) {
            deleByCopy(p.info.type);
            return;
        }
        preOrderAndDelete(p.left);
        preOrderAndDelete(p.right);
    }

//=============================================================
    
    /*
    void f4() - Find the node p having type = 5, then calculate number of nodes in the sub-tree
    with root p. Suppose this number is k, then set p.info.price = k. Output in the file f4.txt must
    be the following:
    (C,10,4) (D,5,2) (E,12,10) (F,3,8) (G,6,12) (H,8,6)
    (C,10,4) (D,5,4) (E,12,10) (F,3,8) (G,6,12) (H,8,6)
    */

    void f4() throws Exception {
        clear();
        loadData(14);;
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
        
        Node p = root;
        while (p != null) {
            if (p.info.type == 5) {
                break;
            }
            if (p.info.type > 5) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        int k = count(p);
        p.info.price = k;
        
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    int count(Node p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return (r);
    }

}
