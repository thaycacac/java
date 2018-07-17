/**
 *
 * @author Thaycacac
 */
//add last
    public void addLast(Person x){
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
    public void addLastCondition(){
        Node p=head;
        while(p!=null){
            if(p.info.age>4) h.addLast(p.info);
            p=p.next;
        }
    }

//add element have max age
    public void addMaxAgeVaoH
    Person k = getMaxColor();
    Node p = head;
    while(p != null){
        if(p.info.age == k.age){
            h.addLast(p.info);
        }
        p = p.next;
    }
	
//dele first no age < 6
    public void deleteFirstCondition(){
     Node p = head;
     while(p != null){
         if(p.info.age<6) dele(p);
         p=p.next;
     }
    }
	
//insert position k
	public void insertPositionK(Person x, int position) {
      if (isEmpty()) head = tail = new Node(x);
      int count = 1;
      Node p = head;
      while (p!= null && count < position) {
          p = p.next;
          count ++;
      }
      Node temp = p.next;
      p.next = new Node(x, temp);
	} 
	
//insert after position k
	public void addAfterPositionK(int k, Person c){
        Node p = new Node(c);
        if(k == -1){
            addFirst(c); 
            return;
        }
        
        int count = 0;
        Node p1 = head;
        while(p1 != null && count < k){
            p1 = p1.next;
            count++;
        }
        
        if(p1.next == null && count == k){
            addLast(c);
            return;
        }
            p.next = p1.next;
            p1.next = p; 
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
	
//search node
	public Node search(int x) 
    {Node p = head;
      while(p != null && p.info != x) p = p.next;
      return p;
	}

//remove a node at position k, starting position 0
	public void remove(int k) {
        if (isEmpty()) {
            return;
        }
        if (k == 0) {//check if node is head
            Node p = head;
            head = head.next;
            p.next = null;

        } else {
            Node p = getNode(k);//get node position k
            if (p == null) {
                return;
            }
            Node q = getNode(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) {
                tail = q;
            }
        }
    }
	//get position k
	public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

//remove a node
    public void remove(Node p){
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
	
//remove a node after position k
    public void removeAfterPosK(int k){
        if(isEmpty()) return;
        //remove head
        if(k == -1) {
            Node p = head;
            head = head.next;
            p.next = null;
        }else {
            Node p = getNode(k + 1);
            if(p == null) return;
            Node q = getNode(k);
            //remove p
            q.next = p.next;
            p.next = null;
            if(p == tail) tail = q;
        }
    }
	
//remove node after 2 node have age < 9
	public void removeAfterTwoNodeAgeSmallerNine(){
		Node p = head;
		while(p != null && p.info.age >= 9){
			p = p.next;
		}
		if(p == null && p.next == null){
			return;
		}
		remove(p.next.next);
	}
	
//remove node thirdth have age < 6
	public void removeThirthAgeSmallerSix(){
		Node p = head;
		int count = 0;
		while(p != null){
			if(p.info.age < 6 && count != 3) count ++;
			else if(p.info.age < 6 && count == 3) break;
			p = p.next;
		}
		remove(p);
	}
	
//remove node first after node have position k
	public void removeFirstAfterPosition(int k){
		Node p = getNode(k);
        if(p == null || p.next == null){//if p is tail then donothing
            return;
        }
        Node q = p.next;//if p is before tail then remove tail
        if(q.next == null){
            tail = p;
            p.next = null;
        }
        else{
            p.next = q.next;
            q.next = null;
        }
	}
	

	
//delete node
	public void dele(Node q)
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
