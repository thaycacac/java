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
    void insert(String xOwner, int xPrice, int xColor) - check if xOwner.charAt(0) == 'A’
    then do nothing, otherwise insert new Bat with owner=xOwner, price=xPrice,
    color=xColor to the tree (price and color can get arbitrary, even negative values).
    */

    void insert(String xOwner, int xPrice, int xColor) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        insert(new Bat(xOwner, xPrice, xColor));

    }
    
    void insert(Bat x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.color == x.color) {
                System.out.println("The key " + x.color + " already exists, no insertion");
                return;
            }
            f = p;
            if (x.color < p.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.color < f.info.color) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }
    
    /*
    void f1() - Do not edit this method. Your task is to complete the insert(...) method above
    only. Output in the file fl.txt must be the following:
    (B,9,4) (C,4,3) (D,8,6) (E,2,5) (F.6,7)
    (C,4,3) (B.9,4) (E.2,5) (D,8,6) (F.6,7)
    */

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
    void f2() - Perform in-order traversal from the root but display to file f2.txt nodes with
    price < 7 only. Hint: Copy the function inOrder(...) to function inOrder2(...) and modify
    it. Output in the file f2,tx¢ must be the following:
    (D,7,2) (H,6,3) (I,5,4) (F,4,5) (C,3,6) (G,8,7) (E,2,8)
    (H,6,3) (I,5,4) (F,4,5) (C,3,6) (E,2,8)
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
        if (p.info.price < 7) {
            fvisit(p, f);
        }
        inOrder2(p.right, f);
    }

//=============================================================

    /*
    void f3() - Suppose the tree is not empty. Find the node p having largest price in the tree
    (i.e. p is the right-most node), then delete p. Output in the file f3.txt must be the
    following:
    (C,5,2) (D,2,1) (E,6,5) (F,1,3) (G,4,6) (H,3,4)
    (C,5,2) (D,2,1) (E,6,S) (F,1,3) (H,3,4)
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
        
        max = 0;
        breadth2(root, f);
        Queue q = new Queue();
        q.enqueue(root);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.color == max) {
                deleByCopy(r.info.color);
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    int max;

    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        max = root.info.color;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.color > max) {
                max = r.info.color;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void deleByCopy(int x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.color == x) {
                break;
            }
            f = p;
            if (x < p.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }      // p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { // p==root
                root = null;
                return;
            }
            if (p == f.left) {
                f.left = null;
            } else {
                f.right = null;
            }
        }
        // p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) { // p==root
                root = p.left;
                return;
            }
            if (p == f.left) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) { // p==root
                root = p.right;
                return;
            }
            if (p == f.left) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // find the right-most node in the left sub-tree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) { // rp==q
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }
    
//=============================================================
    
    /*
    void f4() - Suppose the tree is not empty. Find the node p having largest price in the tree
    (i.e p is the right-most node). If p has father f then rotate f to left about p. Output in the
    file f4.txt must be the following:
    (C,5,2) (D,2,1) (E.6,5) (F,1,3) (G,4,6) (H,3,4)
    (C,5,2) (D,2,1) (G,4,6) (E.6,5) (F,1,3) (H,3,4)
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
        
        max = 0;
        breadth2(root, f);
        Node q123 = null;
        Queue q = new Queue();
        q.enqueue(root);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.color == max) {
                q123 = r;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        Node fa1 = father2(q123.info.color);
        Node r12 = rotateLeft(fa1);
        Node fa2 = father2(fa1.info.color);
        if (fa2 == null) {
            root = r12;
        } else {
            if (fa2.left == fa1) {
                fa2.left = r12;
            } else {
                fa2.right = r12;
            }
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return (q);
    }

    Node father2(int xColor) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.color == xColor) {
                break;
            }
            f = p;
            if (xColor < p.info.color) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }

}
