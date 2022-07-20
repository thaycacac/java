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

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

    int compare(Node a, Node b) {
        return Integer.compare(a.info.price, b.info.price);
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//=============================================================
    
    /*
    void insert(string xOwner, int xColor, int xPrice) - check if xOwner.charAt(0) == 'A' then
    do nothing, otherwise insert new cat with owner=xOwner, color=xColor, price=xPrice to
    the tree. (color and price can get arbitrary values, even negative).
    */
    
    void insert(String xOwner, int xColor, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        Node p = new Node(new Dog(xOwner, xColor, xPrice));
        if (isEmpty()) {
            root = p;
            return;
        }
        Node n = root;
        while (true) {
            int k = compare(n, p);
            if (k == 0) {
                return; // id existed
            } else if (k > 0) {
                if (n.left == null) {
                    n.left = p;
                    return;
                }
                n = n.left;
            } else if (k < 0) {
                if (n.right == null) {
                    n.right = p;
                    return;
                }
                n = n.right;
            }
        }
    }

    /*
    void f1() — You do not need to edit this function. Your task is to complete the insert(...)
    function above only. Output in the file f1.txt must be the following:
    (B,9,5) (C,1,2) (D,5,6) (E,3,4) (F,6,7) (G,2,3)
    (C,1,2) (G,2,3) (E,3,4) (B,9,5) (D,5,6) (F,6,7)
    */
    
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
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
    void f2() — Perform in-order traversal from the root but display to file f2.txt nodes with
    color<5 only. Hint: Copy the function inOrder(...) to function inOrder2(...) and modify it.
    Output in the file f2.txt must be the following:

    (C,5,1) (G,6,2) (H,2,3) (E,7,4) (I,4,5) (D,1,6) (F,3,8)
    (H,2,3) (I,4,5) (D,1,6) (F,3,8)
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
        if (p.info.color < 5) {
            fvisit(p, f);
        }
        inOrder2(p.right, f);
    }

//=============================================================
    
    /*
    void f3Q — Search the node having price=6 in the tree. If the node found is p then calculate
    the number of nodes in the sub-tree with root p. If this number of nodes is k then change
    p.info.color to 100+k. Output in the file f3.txt must be the following:
    (C,9,2) (D,5,1) (E,10,6) (F,3,4) (G,7,8) (H,2,3) (I,4,5) (J,6,7)
    (C,9,2) (D,5,1) (E,106,6) (F,3,4) (G,7,8) (H,2,3) (I,4,5) (J,6,7)
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

        Node p = root;
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r = null;
        while (!q.isEmpty()) {
            r = q.dequeue();
//        fvisit(r,f);
            if (r.info.price == 6) {
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }

        p = r;
        if (p != null) {
            q = new Queue();
            q.enqueue(p);
            Node a;
            int k = 0;
            while (!q.isEmpty()) {
                a = q.dequeue();
                k++;
                if (a.left != null) {
                    q.enqueue(a.left);
                }
                if (a.right != null) {
                    q.enqueue(a.right);
                }
            }
            p.info.color = 100 + k;
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================

    /*
    void f4() — Search the node having price = 6 and if the node found is p then delete p by
    copying. Output in the file f4.txt must be the following:
    (C,9,2) (D,5,1) (E,10,6) (F,3,4) (G,7,8) (H,2,3) (I,4,5) J,6,7)
    (C,9,2) (D,5,1) (I,4,5) (F,3,4) (G,7,8) (H,2,3) (J,6,7)
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
        deleteByCopy(6);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
        void deleteFunc(Node p, Node f) {
        //p do not have child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        //p have one-left child
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else {
                if (f.left == p) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        //p have one-right child
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else {
                if (f.left == p) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        Node p1 = p.left;
        Node f1 = p;
        while (p1.right != null) {
            f1 = p1;
            p1 = p1.right;
        }
        p.info = p1.info;
        if (f1.right == p1) {
            f1.right = p1.left;
        } else {
            f1.left = p1.left;
        }
    }

    void deleteByCopy(int price) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == 6) {
                break;
            }
            f = p;
            if (p.info.price > price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        deleteFunc(p, f);
    }

}
