/**
 *
 * @author Thaycacac
 */
//add last
    void addLast(Person x){
        Node q = new Node(x);
        if(isEmpty()){head=tail=q;return;}
        tail.next=q;tail=q;
    }
	
//add first
    public void addFirst(Person x) 
    {Node p = new Node(x);
     if(isEmpty()) {head = tail = p;}
     else {p.next = head; head = p;}
    }
	
//add if age > 4
    void addLastCondition(){
        Node p=head;
        while(p!=null){
            if(p.info.age>4) h.addLast(p.info);
            p=p.next;
        }
    }
	
//dele first no age < 6
    void deleteFirstCondition(){
     Node p = head;
     while(p != null){
         if(p.info.age<6) dele(p);
         p=p.next;
     }
    }
	
//delete node
	void dele(Node q)
	 {Node f,p; f=null;p=head;
	  while(p!=null)
	   {if(p==q) break;
		f=p;p=p.next;
	   }
	  if(p==null) return;
	  if(f==null)
	   {head=head.next;
		if(head==null) tail=null;
		return;
	   }
	  f.next=p.next;
	  if(f.next==null) tail=f;
	 }
    //sort by string
    public void sort() 
    {Node pi,pj; Person x;
       pi=head;
       while(pi!=null)
         {pj=pi.next;
          while(pj!=null)
           {if(pj.info.name.compareTo(pi.info.name)<0)
               {x=pi.info;pi.info=pj.info;pj.info=x;}
            pj=pj.next;
           }
         pi=pi.next;
       }
    }
	
//sort by integer/ double
	public void sort() 
    {Node pi,pj; Car x;
       pi=head;
       while(pi!=null)
         {pj=pi.next;
          while(pj!=null)
           {if(pj.info.price<pi.info.price)
               {x=pi.info;pi.info=pj.info;pj.info=x;}
            pj=pj.next;
           }
         pi=pi.next;
       }
    }
	
//traverse
    public void traverse(){
      MyList h=new MyList();
       Node p=head;Person x;
       while(p!=null)
         {x=p.info;h.addFirst(x);
          p=p.next;
         }
       head=h.head;tail=h.tail;
    }
	
//append another list
    void appendAnotherList(MyList h){
      Node p=h.head;
         while(p!=null)
          {addLast(p.info);
            p=p.next;
      }
    }
	
//delete index
    void deleteAt(int k){
      Node p=head;
        int i=0;
        while(p!=null)
          {if(i==k) break;
            p=p.next;i++;
           }
        dele(p);
    }
	
//change name first
    void changeNameFirst(){
      Node p=head;
        while(p!=null)
         {if(p.info.name.equals("C6")) {p.info.name="CX";break;}
           p=p.next;
         }
	}
}
