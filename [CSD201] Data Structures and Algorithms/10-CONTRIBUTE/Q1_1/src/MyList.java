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
    void addLast(String xMaker, int xType, int xRadius) - check ¡f xMaker.char At(0) — 'B'
    then do nothing, otherwise add new node with maker=xMaker, type=xType,
    radius=xRadius to the end of the list. (type and radius can get arbitrary, even negative
    values).
    
    void f1() - Do not edit this method. Your task is to complete the addLast(...) method
    above only. Qutput in the file fl.txt must be the following:
    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,7)
 */   
    
    
    void addLast(Ball x)
     {Node q = new Node(x);
       if(isEmpty()) {head=tail=q;return;}
       tail.next = q;
       tail = q;
     }

    void addLast(String xMaker, int xType, int xRadius) {
        //You should write here appropriate statements to complete this function.
        if(xMaker.charAt(0)=='B') return;
        addLast(new Ball(xMaker, xType, xRadius));
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
    void f2() -There are 2 given Ball objects x, y ¡n this function. Suppose the list contains
    at least 5 elements. Write statements to insert x and y to the list so that x wIll be the 3rd,
    y wIll be the 4th element in the list. Output in the file f2.txt must be the following:

    (C.9,8) (D,6,3) (E,8,5) (F.5.4) (I.4.9)
    (C,9,8) (D,6,3) (X,1,2) (Y,3,4) (E,8,5) (F.5,4) (4.9)
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
        insertAfter(pos(1), y);
        insertAfter(pos(1), x);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
        void insertAfter(Node q, Ball x){
       if(isEmpty() || q==null) return;
       Node q1=q.next;
       Node p=new Node(x,q1);
       q.next=p;
       if(tail==q) tail=p;
     }
    
    Node pos(int k)
     {int i=0;
      Node p=head;
      while(p!=null) {
        if(i==k) return(p);
        i++;
        p=p.next;
      }
      return(null);
     }
    

//==================================================================
    
    /*
    void f3() - Suppose the list contains at least 4 elements. Remove the second node having
    maximum type (thus If only one node having maximum type then do nothing). Ôutput in
    the file f3.txt must be the following:

    (C,8,6) (D,3,5) (E,9,2) (F,5,6) (G,9,7) (H,6,2) (I,7,8)
    (C.8,6) (D.3,5) (E.9,2) (F,5,6) (H,6,2) (I,7,8)
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
        int max = maxType();
        int count=0;
        Node p=head;
        while(p!=null){
            if(p.info.type==max){
                count++;
                if(count==2) remove(p);
            }
            p=p.next;
         }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void removeFirst() {
      if(isEmpty()) return;
      head=head.next;
      if(head==null) tail=null;
   }
   void remove(Node q)
     {if(isEmpty() || q==null) return;
      if(q==head) {
         removeFirst();
         return;
      }
       Node f=head;
       while(f!=null && f.next!=q) f=f.next;
       if(f==null) return; // q is not in the list
       Node q1=q.next;
       f.next=q1;
       if(f.next==null) tail=f;
     }
    
    int maxType()
     {Node p=head;
     int max=p.info.type;
       while(p!=null)
         {if(p.info.type>max) max=p.info.type;
           p=p.next;
         }
      return max;
     }


//==================================================================

    /*
    void f4) - Suppose the list contains at least 4 elements. Sort the first 4 elements
    descendingly by type. The content of the output file f4.txt must be the following:
    (C,2,1) (D,12,2) (E,3,11) (F.4,3) (I,5,4) (J,6,5) (K,7,6)
    (D,12,2) (F.4.3) (E.3,1 1) (C.2,L) (I,5,4) (J,6,5) (K.7,6)
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
        sortByType(0, 3);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
        void sortByType(int  k, int h)
     {if(k>h) return;
      if(k<0) k=0;
      int n=size();
      if(h>n-1) h=n-1;
      Node u=pos(k);
      Node v=pos(h+1);
      Node pi,pj; Ball x;
      for(pi=u;pi!=v;pi=pi.next) 
        for(pj=pi.next;pj!=v;pj=pj.next)
          if(pj.info.type>pi.info.type) {
            x=pi.info;pi.info=pj.info;pj.info=x;
          }
    
     }
    
    int size()
     {int i=0;
      Node p=head;
      while(p!=null) {
         i++;
         p=p.next;
      }
      return(i);
     }

}
