/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//==================================================================
    
    /*
    void addLast(String xOwner, int xColor, it xPrice) - check ¡f xOwner.charAt(0) == 'B' then
    do nothing, otherwise add new node with owner=xOwner, color=xColor, price=xPrice to
    the end of the list. (color and price can get arbitrary values, even negatIve).
    */
    
    void addLast(String xOwner, int xColor, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B') {
            return;
        }
        Node p = new Node(new Dog(xOwner, xColor, xPrice));
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
    
    /*
    void f1()— This method 1s used to test the addLast method above. You do not need to edit
    this function. Qutput ¡in the file fI.txt must be the following:

    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
    */

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
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
        ftraverse(f);
        f.close();
    }

//==================================================================
    
    /*
    votd f2() -There are 2 given Dog obJects x, y ¡m this function. Suppose the list contains at
    least 3 elements. WriIte statements to mnsert x and y to the list so that x will be the first, y
    will be the third elements of the list. output in the file f2.txt must be the following:

    (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
    (X,1,2) (C,9,8) (Y,3,4) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
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
        ftraverse(f);
        Dog x, y;
        x = new Dog("X", 1, 2);
        y = new Dog("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//     Node p = head;
//     Node p1 = new Node(x, p);
//     head = p1;
//     Node p2 = new Node(y, p.next);
//     p.next = p2;

        insertAfter(head, y);
        insertBefore(head, x);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void insertAfter(Node q, Dog x) {
        if (q == null) {
            return;
        }
        Node p = q.next;
        Node f = new Node(x, p);
        q.next = f;
        if (tail == q) {
            tail = f;
        }
    }

    void insertBefore(Node q, Dog x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; //q is not in the list
        }
        insertAfter(f, x);// before q
    }

    void addFirst(Dog x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }
//==================================================================
    
    /*
    void f3() — Suppose the list contains at least 3 clements. Delete the first and the third
    elements of the original list. Output in the file f3.txt must be the following:

    (C,9,2) (D,2,5) (E,8,7) (F,1,6) (I,5,9)
    (D,2,5) (F,1,6) (I,5,9)
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//        Node p2 = head.next, p3 = p2.next;
//        head = p2;
//        p2.next = p3.next;
//        if (tail == p3) {
//            tail = p2;
//        }
        removeFirst();
        remove(head.next);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; //q is not in the list
        }

        //f.next=q
        Node p = q.next;
        f.next = p;
        if (f.next == null) {
            tail = f;
        }
    }

//==================================================================
    
    /*
    void f4() — Sort the first 5 elements descendingly by color. The content of the output file
    f4.(xt must be the following:

    (C,1,2) (D,2,12) (E,11,3) (E,3,4) (I,4,5) (J,5,6) (K,6,7)
    (E,11,3) (I,4,5) (F,3,4) (D,2,12) (C.12) (J,5,6) (K,6,7)
    */
    
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p1 = head;
        int i = 1;
        while (p1 != null && i <= 5) {
            Node p2 = p1.next;
            int j = i + 1;
            while (p2 != null && j <= 5) {
                if (p1.info.color < p2.info.color) {
                    Dog temp = p1.info;
                    p1.info = p2.info;
                    p2.info = temp;
                }
                p2 = p2.next;
                j++;
            }
            p1 = p1.next;
            i++;
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
