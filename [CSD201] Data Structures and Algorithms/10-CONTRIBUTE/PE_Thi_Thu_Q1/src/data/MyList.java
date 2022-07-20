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

    void loadData(int k) { //do not edit this function
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
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    
    /*
    void addLast(String xForest, int xRate, int xSound) - check if xForest.charAt(0) == ‘B' then do
    nothing, otherwise add new node with forest=xForest, rate=xRate, sound=xSound to the end of
    the list. (rate and sound can get arbitrary, even negative values).

    void f1() — Do not edit this method. Your task is to complete the addLast(...) method above only.
    Output in the file f1.toct must be the following:
    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
    */

    void addLast(String xForest, int xRate, int xSound) {
        //You should write here appropriate statements to complete this function.
        if (xForest.charAt(0) == 'B') {
            return;
        }
        Boo p = new Boo(xForest, xRate, xSound);
        addLast(p);
    }
    
    public void addLast(Boo p) {
        Node newNode = new Node(p);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
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
    void f2() - There are 2 given Boo objects x, y in this function. Suppose the list contains at beast 3
    elements. Write statements to insert x and y to the list so that x will be the 2nd, y will be the 3rd
    elements in the list. Output in the file f2.0ct must be the following:
    (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
    (C,9,8) (X,1,2) (Y,3,4) (D,6,3) (E,8,5) (F,5,4) (I,4,9)
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
        Boo x, y;
        x = new Boo("X", 1, 2);
        y = new Boo("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        insertAfter(pos(0), y);
        insertAfter(pos(0), x);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    void insertAfter(Node q, Boo x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

//==================================================================
    
    /*
    void f3() -— Suppose the list contains at least 3 elements. Delete the first and the third elements of
    the original list. Output in the file f3.txt must be the following:
    (C,8,6) (D,3,5) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
    (D,3,5) (F,5,8) (G,9,7) (H,6,8) (I,7,3)
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
        
        remove(pos(2));
        removeFirst();

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
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; // q is not in the list
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

//==================================================================
    
    /*
    void f4() — Suppose the list contains at least 4 elements. Sort the first 4 elements ascendingly by
    rate. The content of the output file #4.tct must be the following:
    (C,7,11) (D,10,7) (E,6,5) (F,5,6) (I,4,4) (J,3,2) (K,2,1)
    (F,5,6) (E,6,5) (C,7,11) (D,10,7) (I,4,4) (J,3,2) (K,2,1)
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
        
        sort(0, 3);
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void sort(int k, int h) {
        if (k > h) {
            return;
        }
        if (k < 0) {
            k = 0;
        }
        int n = size();
        if (h > n - 1) {
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h + 1);
        Node pi, pj;
        Boo x;
        for (pi = u; pi != v; pi = pi.next) {
            for (pj = pi.next; pj != v; pj = pj.next) {
                if (pj.info.rate < pi.info.rate) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
            }
        }

    }

    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

}
