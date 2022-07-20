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

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    
    /*
    void insert(String xColor, int xArea, int xPeri) - check if xColor.charA1(0) == 'B' then do
    nothing, otherwise insert new box with color=xColor, area=xArea, peri=xPeri to the tree
    (area and peri can get negative value).
    
    void f1() - You do not need to edit this function. Your task is to complete the insert(...)
    function above only. Output in the file fl.tx¢ must be the following:
    (A,4,2) (C,1,2) (D,5,6) (E,3,4) (F,6,7) (G,2,3)
    (C,1,2) (G,2,3) (E,3,4) (A,4,2) (D,5,6) (F,6,7)
    */
    
    void insert(String xColor, int xArea, int xPeri) {//You should insert here statements to complete this function
        if (xColor.charAt(0) == 'B') {
            return;
        }
        Node p = new Node(new Box(xColor, xArea, xPeri));
        if (isEmpty()) {
            root = p;
            return;
        }
        Node f = null, q = root;
        while (q != null) {
            if (q.info.area == xArea) {
                return;
            }
            if (q.info.area > xArea) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.area > xArea) {
            f.left = p;
        } else {
            f.right = p;
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(3);
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
    void f2() — Perform post-order traversal from the root but display to file f2.txt nodes with
    peri < 5 only. Hint: Copy the function postOrder(...) to function postOrder2(...) and modify
    it. Output in the file f2.txt must be the following:
    (H,2,3) (I,4,5) (F,3,8) (D,1,6) (G,6,2) (E,7,4) (C,5,1)
    (H,2,3) (G,6,2) (E,7,4) (C,5,1)
    */

    void f2() throws Exception {
        clear();
        loadData(7);
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
        if (p.info.peri < 5) {
            fvisit(p, f);
        }
    }

//=============================================================

    /*
    void f3() — Perform pre-order traversal and find the first node p having left son only, then
    rotate p to right about it’s left son. Output in the file f3.txt must be the following:
    (C,5,5) (D,1,4) (E,7,6) (F,4,1) (G,6,7) (H,2,3) (I,3,2)
    (C,5,5) (D,1,4) (E,7,6) (H,2,3) (G,6,7) (F,4,1) (I,3,2)
    */

    void f3() throws Exception {
        clear();
        loadData(11);
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

        breadth3(root, f);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    Node father2(Node node) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p == node) {
                break;
            }
            f = p;

            if (p.info.area > node.info.area) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }

    Node rotateRight(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        Node pl = node.left;
        node.left = pl.right;
        pl.right = node;
        return pl;
    }

    void myRotateRight(Node node) {
        Node tmp = rotateRight(node);
        Node parent = father2(node);
        if (parent == null) {
            root = tmp;
        } else {
            if (parent.left == node) {
                parent.left = tmp;
            } else {
                parent.right = tmp;
            }
        }
    }

    void breadth3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();

            if (r.left != null && r.right == null) {
                myRotateRight(r);
                break;
            }

            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

//=============================================================

    /*
    void f4() — Perform pre-order traversal and find the first node p having left son q only, then
    delete q by copying. Output in the file f4.txt must be the following:
    (C,5,5) (D,1,4) (E,7,6) (F,4,1) (G,6,7) (H,2,3) (I,3,2)
    (C,5,5) (D,1,4) (E,7,6) (F,4,1) (G,6,7) (I,3,2)
    */

    void f4() throws Exception {
        clear();
        loadData(15);;
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
        
        breadth2(root, f);
        
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        Node q = root;
        Node f = null;
        while (q != p) {

            if (q.info.area > p.info.area) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (p.left == null && p.right == null) {
            if (f == null)
            {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else if (f.right == p) {
                f.right = null;
            }
        }
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        }
        else if (p.right != null && p.left == null) {
            if (f == null) {
                root = p.right;
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        }
        if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }

    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();

            if (r.left != null && r.right == null) {
                deleteByCopy(r.left);
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

}
