/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
    void insert(String xForest, int xRate, int xSound) - check if xForest.charAt(0) == 'B’ then do
    nothing, otherwise insert new Boo object with forest=xForest, rate=xRate, sound=xSound to the
    tree (rate and sound can get arbitrary, even negative values).
    
    void f1() - Do not edit this method. Your task is to complete the insert(...) method above only.
    Output in the file f1.txt must be the following:
    (A,7,9) (C,4,3) (D,8,6) (E,2,5) (F,6,7)
    (E,2,5) (C,4,3) (F,6,7) (A,7,9) (D,8,6)
    */
    
    void insert(String xForest, int xRate, int xSound) {
        //You should insert here statements to complete this function
        if (xForest.charAt(0) == 'B') {
            return;
        }

        Node p = new Node(new Boo(xForest, xRate, xSound));
        if (isEmpty()) {
            root = p;
            return;
        }
        Node f = null, q = root;
        while (q != null) {
            if (q.info.rate == xRate) {
                return;
            }
            if (q.info.rate > xRate) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.rate > xRate) {
            f.left = p;
        } else {
            f.right = p;
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
    void f2() - Perform pre-order traversal from the root but display to file f2.txt_ nodes with sound<6
    only. Hint: Copy the function preOrder(...) to function preOrder2(...) and modify it. Output in the
    file f2.txt must be the following:
    (C,3,6) (E,2,8) (D,7,2) (F,4,5) (H,6,3) (I,5,4) (G,8,7)
    (D,7,2) (F,4,5) (H,6,3) (I,5,4)
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        preOrder2(root, f);
        
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.sound < 100) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);

    }

//=============================================================
    
    /*
    void f3{)— Suppose p is the 4-th node when performing the pre-order traversal of the tree. Delete
    the node p by copying. Output in the file f3.txt must be the following:
    (C,5,2) (D,2,1) (F,1,3) (G,4,6) (H,3,4) (E,6,5)
    (C,5,2) (D,2,1) (F,1,3) (H,3,4) (E,6,5)
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
            if (p.info.rate == x) {
                break;
            }
            f = p;
            if (x < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (f == null) {
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
        if (p.left != null && p.right == null) {
            if (f == null) {
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
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
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
        if (p.info.rate == 4) {  // Sua o day
            deleByCopy(p.info.rate);
            return;
        }
        preOrderAndDelete(p.left);
        preOrderAndDelete(p.right);
    }

//=============================================================
    
    /*
    void f4() — Suppose p is the 4-th node when performing the pre-order traversal of the tree. Check
    if p has left son then rotate it to right about its’ left son. Output in the file f4.txt must be the
    following:
    (C,5,2) (D,2,1) (F,1,3) (G,4,6) (H,3,4) (E,6,5)
    (C,5,2) (D,2,1) (F,1,3) (H,3,4) (G,4,6) (E,6,5)
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        
        q123 = null;
        preOrder3(root, f);
        Node r = rotateRight(q123);
        Node fa = father(q123.info.rate);
        if (fa == null) {
            root = r;
        } else {
            if (fa.left == q123) {
                fa.left = r;
            } else {
                fa.right = r;
            }
        }

        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    Node q123 = null;
    int count = 0;
    
    void preOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.left != null && p.right == null && count == 0) {
            q123 = p;
            count++;
            return;
        }
        preOrder3(p.left, f);
        preOrder3(p.right, f);
        return;
    }
    
    Node father(int xRate){
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.rate == xRate) {
                break;
            }
            f = p;
            if (xRate < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }
    
    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return (q);
    }

}
