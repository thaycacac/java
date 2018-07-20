/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------------
class BSTree
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

  void fvisitBal(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.bal+") ");
    }

  void fvisitLevel(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.level+") ");
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
     MyQueue q = new MyQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }

  void breadthBal(Node  p, RandomAccessFile f) throws Exception
   {if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitBal(r,f);
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
   }

  void breadthLevel(Node  p, RandomAccessFile f) throws Exception
   {if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitLevel(r,f);
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
   }

   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("person.txt", k);
      int [] b = Lib.readLineToIntArray("person.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//===========================================================================
  void insert(Person x)
   {Node q=new Node(x);
     if(isEmpty())
      {root=q;
        return;
       }
     Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.name.equals(x.name))
          {System.out.println("The key " + x.name + " already exists, no insertion");
            return;
          }
         f=p;
         if(x.name.compareTo(p.info.name)<0) p=p.left; else p=p.right;
       } 
      if(x.name.compareTo(f.info.name)<0) f.left=q; else f.right=q;
   }

  void insert(String xName, int xAge)
     {if(xName.charAt(0) == 'B') return;
       Person x = new Person(xName,xAge);
       insert(x);
       
     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
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
  
//===============================================================


  void f2() throws Exception
    {clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     BSTree h = new BSTree();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


int xAge = 4;
     MyQueue q = new MyQueue();
     q.enqueue(root);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        if(r.info.age>xAge) h.insert(new Person(r.info.name,r.info.age));
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }


    //-------------------------------------------------------------------------------------
     h.preOrder(h.root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
int height(Node p)
 {if(p==null) return(0);
   int k,h,r;
   k = height(p.left);
   h = height(p.right);
   r = k>h?k:h;
   return(r+1);
 }
  void f3() throws Exception
    {clear();
     loadData(5);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     int k = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
k = height(root);

    //-------------------------------------------------------------------------------------
     f123.writeBytes(" k = " + k + "\r\n");
     f123.close();
    }  

//===============================================================
int count(Node p)
 {if(p==null) return(0);
   int k,h,r;
   k = count(p.left);
   h = count(p.right);
   r = k+h+1;
   return(r);
 }
  void f4() throws Exception
    {clear();
     loadData(5);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     int k = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

k = count(root);
    //-------------------------------------------------------------------------------------
     f123.writeBytes(" k = " + k + "\r\n");
     f123.close();
    }  

//===============================================================
  void deleByCopy(String xName)
   {Node f,p;
     f=null;p=root;
     while(p!=null)
       {if(p.info.name.equals(xName)) break;
         f=p;
         if(xName.compareTo(p.info.name)<0) p=p.left; else p=p.right;
       }
      if(p==null) return; // not found
      
      // p is leaf node
      if(p.left==null && p.right==null)
        {if(f==null) // p=root
           {root=null;
           }
           else
            {if(p==f.left) f.left=null; f.right=null;
             }
          return;
        } 

      // p has left child only
      if(p.left!=null && p.right==null)
        {if(f==null) // p=root
           {root=p.left;
           }
           else
            {if(p==f.left) f.left=p.left; f.right=p.left;
             }
          return;
        } 

      // p has right child only
      if(p.left==null && p.right!=null)
        {if(f==null) // p=root
           {root=p.right;
           }
           else
            {if(p==f.left) f.left=p.right; f.right=p.right;
             }
          return;
        } 

      // p has both 2 children
      if(p.left!=null && p.right!=null)
        {// find the right most node
          Node q=p.left;
          Node frp, rp; frp=null;rp=q;
          while(rp.right!=null) {frp=rp;rp=rp.right;}
          // rp is the right most node on the left child
          p.info=rp.info;
          if(frp==null) // rp=q
           {p.left=q.left;
           }
           else
           {
            frp.right=rp.left; 
           }
        }

   }
  void f5() throws Exception
    {clear();
     loadData(5);
     String fname = "f5.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

deleByCopy(root.info.name);
    //-------------------------------------------------------------------------------------
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
 Node rotateToRight(Node p)
  {if(p==null || p.left==null) return(p);
    Node q=p.left;
    p.left=q.right;
    q.right=p;
    return(q);
  }

  void f6() throws Exception
    {clear();
     loadData(5);
     String fname = "f6.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

root = rotateToRight(root);
    //-------------------------------------------------------------------------------------
     breadth(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f7() throws Exception
    {clear();
     loadData(5);
     String fname = "f7.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
boolean isAVL = true;
     MyQueue q = new MyQueue();
     q.enqueue(root);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
         r.bal = height(r.right) - height(r.left);
         if(r.bal>=2 || r.bal<=-2) isAVL = false;
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }

     breadthBal(root,f123);
if(!isAVL)
 f123.writeBytes("\r\nThe tree is not an AVL tree\r\n");
 else
  f123.writeBytes("\r\nThe tree is an AVL tree\r\n");

    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f8() throws Exception
    {clear();
     loadData(5);
     String fname = "f8.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


     MyQueue q = new MyQueue();
if(isEmpty()) return; 
root.level=1;
     q.enqueue(root);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        if(r.left!=null) r.left.level = r.level +1;
        if(r.right!=null) r.right.level = r.level +1;
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }

     breadthLevel(root,f123);

    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
void inOrder(ArrayList<Person> t, Node p)
  {if(p==null) return;
    inOrder(t,p.left);
    t.add(p.info);
    inOrder(t,p.right);
  }
void balance(ArrayList<Person> t, int i, int j)
  {if(i>j) return;
    int k=(i+j)/2;
    insert(t.get(k));
    balance(t,i,k-1);
    balance(t,k+1,j);
  }
void balance()
   {ArrayList<Person> t;
     t = new ArrayList<Person>();
     inOrder(t,root);
     int n = t.size();
     clear();
     balance(t,0,n-1);
   }

  void f9() throws Exception
    {clear();
     loadData(5);
     String fname = "f9.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

balance();
     breadth(root,f123);
    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

 }
