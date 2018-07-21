/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
      public void addLast(Car c) {
        Node p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;                       
            tail = p;                           
        }
    }
  
  void addLast(String xOwner, int xRate, int xPrice)
   {//You should write here appropriate statements to complete this function.
       if(xOwner.startsWith("B")){
           return;
       }
       Car c = new Car(xOwner, xRate, xPrice);
       addLast(c);
   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(2);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
   public void addFirst(Car c) {
        Node p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }
  
  void f2() throws Exception
    {clear();
     loadData(6);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Car x, y;
     x = new Car("X",1,2);
     y = new Car("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(y);
        addFirst(x);


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
 void remove(Node p){
      if(p == null || isEmpty()){
          return;
      }
      Node f = null, q = head;
      // Find the a node before p 
      while( q!= null && q != p){
          f = q;
          q = q.next;
      }
      if(f == null){
          // Remove f
          head = head.next;
          if(head == null){
              tail = null;
          }
      }
      else{
          f.next = p.next;
          if(p == tail){
              tail = f;
          }
      }   
  }
  
  void f3() throws Exception
   {clear();
    loadData(6);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node q = head;
        int countf3 = 0;
        while(q != null){
            Node temp = q.next;
            if(countf3 == 1 || countf3 == 3){
                remove(q);
            }
            countf3++;
            q = temp;
        }


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
      public Node getNode(int k) {          
        int c = 0;                              
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;                                
        }
        return p;                               
    }
  
  public int size() {
        int c = 0;
        Node p = head;
        while (p != null) {
            p = p.next;
            c++;
        }
        return c;
    } 
  
  void f4() throws Exception
   {clear();
    loadData(10);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    int n = (size() > 4) ? 4 : size();

    for(int i = 0; i < n-1; i++){          
         for(int j = i+1; j < n; j++){
             Node pi = getNode(i);
             Node pj = getNode(j);
             if(pi.info.rate > pj.info.rate){
                 Car temp = pi.info;
                 pi.info = pj.info;
                 pj.info = temp;
             }
         }
     }


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
