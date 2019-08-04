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
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(String xOwner, int xPrice)
   {//You should write here appropriate statements to complete this function.
       if(xOwner.charAt(0) == 'B' || xPrice>100 ) return;
       else {
               addLast(new Person(xOwner, xPrice));
               }
   }
  public void addLast(Person x){
        Node q = new Node(x);
        if(isEmpty()){head=tail=q;return;}
        tail.next=q;tail=q;
    }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Person x = new Person("X",1);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(x);


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  
  public void addFirst(Person x){
		Node p = new Node(x);
		if(isEmpty()) {head = tail = p;}
		else {p.next = head; head = p;}
    }

//==================================================================
  void f3() throws Exception
   {clear();
    loadData(7);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    int x = 5;
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteFirstCondition();


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
  public void deleteFirstCondition(){
		Node p = head;
		while(p != null){
			if(p.info.age<6){
                            dele(p); break;
                        }
			p=p.next;
		}
    }
  public void dele(Node q){
		Node f,p; f=null;p=head;
		while(p!=null){
			if(p==q) break;
			f=p;p=p.next;
		}
		if(p==null) return;
		if(f==null){
			head=head.next;
			if(head==null) tail=null;
			return;
		}
		f.next=p.next;
		if(f.next==null) tail=f;
	 }

//==================================================================
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
     sort();


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
  
  public void sort() {
		Node pi,pj; Person x;
		pi=head;
		while(pi!=null){
			pj=pi.next;
			while(pj!=null){
				if(pj.info.age<pi.info.age){
					x=pi.info;pi.info=pj.info;pj.info=x;
				}
				pj=pj.next;
			}
			pi=pi.next;
		}
    }

 }
