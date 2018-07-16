/**
 *
 * @author Thaycacac
 */
//insert node with object
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

//inser elements having age > 4
    void insertCondition(BSTree h){
      int xAge = 4;
     MyQueue q = new MyQueue();
     q.enqueue(root);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        if(r.info.age>xAge) h.insert(new Person(r.info.name,r.info.age));
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }

//preorder with condition: 3 <= price <= 5
	void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
     if(p.info.price>=3&&p.info.price<=5){
        fvisit(p,f);
     }
     preOrder2(p.left,f);
     preOrder2(p.right,f);
     }
	
//calculate the height
    int height(Node p)// import root
    {if(p==null) return(0);
     int k,h,r;
     k = height(p.left);
     h = height(p.right);
      r = k>h?k:h;
      return(r+1);
    }
	
//Delete the root of  the tree by copying : deleByCopy(root.info.name);
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
	
/*
Check if the root having non-empty left-son then rotate it to right about its left-son.
root = rotateToRight(root);
    */
    Node rotateToRight(Node p)
    {if(p==null || p.left==null) return(p);
        Node q=p.left;
        p.left=q.right;
        q.right=p;
        return(q);
    }
/*Calculate balance factor of all nodes. Display all node with balance 
factor by breadth-first traverse. Display also the information about whether 
a given binary search tree is height balanced (AVL tree) or not.*/
    void calculateBalanceAndDisplay(RandomAccessFile  f123) throws Exception{
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
  }
  
//calculate level all node
    void levelNode(RandomAccessFile  f123) throws Exception{
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
  }
/*
Balance a binary search tree by simple balancing algorithm. Display all 
node by breadth-first traverse.
*/
    
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
    
}