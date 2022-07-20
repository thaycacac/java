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
    void addLast(String xOwner, int xPrice) - check if xOwner.charAt(0) == 'B' or xPrice>100
    do nothing, otherwise add new car with owner=xOwner, price=xPrice, price=xPrice to
    the end of the list. (price can get arbitrary value, even negative).
    
    void f1() - This method is used to test the addLast methode above. You do not need to edit
    this function. Output in the file f.txt must be the following:
    (A,9) (C,7) (D,2) (E,6) (F,4)
    */
    
    void addLast(String xMaker, int xType, int xRadius) {
        //You should write here appropriate statements to complete this function.
        if (xMaker.charAt(0) == 'B' || xType < 0 || xRadius < 0) {
            return;
        }
        Ball ball = new Ball(xMaker, xType, xRadius);
        Node node = new Node(ball);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
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
    void f2() - There is a given objects x. You should write statements so that x will be the
    first element of the list. Output in the file f2.txt must be the following:
    (C,9) (D,6) (E,8) (F,2) (I,6)
    (X,1) (C,9) (D,6) (E,8) (F,2) (I,6)
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
        Ball x, y;
        x = new Ball("X", 1, 2);
        y = new Ball("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        addIndex(x, 2);
        addIndex(y, 3);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void addFirst(Ball value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addIndex(Ball value, int index) {
        if (index <= 0) {
            addFirst(value);
        }
        if (index >= size()) {
            addLast(value.maker, value.type, value.radius);
        }
        int count = 0;
        Node cur = head;
        while (cur != null && count != index - 1) {
            count++;
            cur = cur.next;
        }
        Node node = new Node(value);
        node.next = cur.next;
        cur.next = node;
    }

//==================================================================
    
    /*
    void f3() — Suppose the list contains at least 3 elements. Delete the first node having
    price = 5. Output in the file f3.txt must be the following:
    (C,9) (D,5) (E,3) (F,5) (I,6)
    (C,9) (E,3) (F,5) (I,6)
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
        Node node = head;
        int i = 0;
        int max = head.info.type;
        int maxIndex = 0;
        while (node != null) {
            if (node.info.type > max) {
                max = node.info.type;
                maxIndex = i;
            }
            i++;
            node = node.next;
        }

        node = head;
        i = 0;
        max = head.info.type;
        int maxIndex2 = 0;
        while (node != null) {
            if (node.info.type > max && i != maxIndex) {
                max = node.info.type;
                maxIndex2 = i;
            }
            i++;
            node = node.next;
        }
        delete(maxIndex2);
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void delete(int index) {
        if (index == 0) {
            head = head.next;
        }
        if (index == size() - 1) {
            Node beforeTail = head;
            while (beforeTail.next != tail) {
                beforeTail = beforeTail.next;
            }
            beforeTail.next = null;
            tail = beforeTail;

        }
        if (index > 0 && index < size() - 1) {
            int count = 0;
            Node cur = head;
            while (count != index - 1) {
                cur = cur.next;
                count++;
            }
            cur.next = cur.next.next;
        }
    }

//==================================================================
    
    /*
    void f4() ~ Sort the list ascendingly by price Output in the file f4.tve must be the following
    (C,9) (D,6) (E,5) (F,13) (I,2) (J,1)
    (J,1) (I,2) (E,5) (D,6) (C,9) (F,13)
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
        
        Node cur = head;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i - 1; j++) {
                Node lhs = get(j);
                Node rhs = get(j + 1);
                if (lhs.info.type < rhs.info.type) {
                    Ball temp = lhs.info;
                    lhs.info = rhs.info;
                    rhs.info = temp;
                }
            }
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    int size() {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    Node get(int index) {
        if (index == 0) {
            return head;
        }
        if (index == size() - 1) {
            return tail;
        }
        if (index > 0 && index < size() - 1) {
            int i = 0;
            Node cur = head;
            while (i != index) {
                cur = cur.next;
                i++;
            }
            return cur;
        } else {
            return null;
        }
    }

}
