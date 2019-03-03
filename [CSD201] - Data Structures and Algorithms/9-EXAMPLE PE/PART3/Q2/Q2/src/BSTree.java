/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

//-------------------------------------------------------------------------------
public class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     BQueue q = new BQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  public void insert(Bus x){
        Node p = new Node(x);
        if(isEmpty()){
            root = p;
            return;
        }
        Node f = null;        
        Node q = root;
        while(q != null){
            if(q.info.price == x.price){            
                return;
            }
            else if(q.info.price > x.price){
                f = q;                      
                q = q.left;
            }
            else{
                f = q;
                q = q.right;
            }
        }
        if(f.info.price > x.price){
            f.left = p;
        }
        else{
            f.right = p;
        }
    }
   
   void insert(String xDriver, int xRate, int xPrice)
     {//You should insert here statements to complete this function
          if(xDriver.startsWith("A")){
           return;
       }
       Bus c = new Bus(xDriver, xRate, xPrice);
       insert(c);

     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(2);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     inOrder(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  
  
//=============================================================
   void preOrderf2(Node p, RandomAccessFile f) throws Exception
     {
      if(p==null) return;
      if(p.info.price < 7){
        fvisit(p,f);
      }
      preOrderf2(p.left,f);
      preOrderf2(p.right,f);
     }
  
  void f2() throws Exception
    {clear();
     loadData(6);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrderf2(root, f);


    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if(p == null){
            System.out.println("Key does not exists, deletion failed");
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while(q != p){
            if(q.info.price > p.info.price){         // Changed
                f = q;
                q = q.left;
            }
            else{
                f = q;
                q = q.right;
            }
        }
        // 1. p is a leaf (no right and left child)
        if (p.left == null && p.right == null) {
            // a BST has a Node only
            if (f == null) {
                root = null;
            } 
            else if (f.left == p) {
                f.left = null;
            }
            else if(f.right == p){
                f.right = null;
            }
        }
        // 2. p has a left child only
        else if(p.left != null && p.right == null){
            if(f == null){// remove root
                root = p.left;
            }
            else if(f.right == p){
                f.right = p.left;
            }
            else if(f.left == p){
                f.left = p.left;
            }
        }
        // 3. p has a right child only
        else if(p.right != null && p.left == null){
            if(f == null){// remove root
                root = p.right;
            }
            else if(f.right == p){
                f.right = p.right;
            }
            else if(f.left == p){
                f.left = p.right;
            }
        }
        // 4. Both of right and left child 
        else if(p.left != null && p.right != null){
            f = null;
            Node rp = p.left;
            while(rp.right != null){
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if(f == null){// rp has no right child 
                p.left = rp.left;
            }
            else{
                f.right = rp.left;
            }
        }
    }
    int countf3 = 0;
    public void preorderf3(Node p){
        if(p == null){
            return;
        }
        countf3++;
        if(countf3 == 4){
            deleteByCopy(p);
            return;
        }
        preorderf3(p.left);
        preorderf3(p.right);
    }
  void f3() throws Exception
    {clear();
     loadData(6);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preorderf3(root);


    //------------------------------------------------------------------------------------
     preOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
    public Node getNode(int x) {
        Node p = root;
        while (p != null) {
            if (p.info.price > x) p = p.left;
            else if (p.info.price < x) p = p.right;
            return p;
        }
        return null;
    }
    
  void f4() throws Exception
    {clear();
     loadData(6);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = getNode(7);
        while(p.right != null){
            p = p.right;
        }
        p.info.rate = 100;

    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
