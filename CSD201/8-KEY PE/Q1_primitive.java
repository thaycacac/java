//add last
    public void addLast(int x) 
    {Node p = new Node(x);
     if(isEmpty()) {head = tail = p;}
     else {tail.next = p; tail = p;}
    }
	
//add first
	public void addFirst(int x) 
    {Node p = new Node(x);
     if(isEmpty()) {head = tail = p;}
     else {p.next = head; head = p;}
    }
	
//return number of nodes in the list
    public int size() 
    {Node p = head; int c = 0;
      while(p != null) {c++; p = p.next;}
      return c;
    }
	
//sort the list ascending 
    public void sort() 
    {int n = size();
     for (int i = 0; i < n - 1; i++) 
     {for (int j = i + 1; j < n; j++) 
     {Node pi = get(i), pj = get(j);
       if(pi.info > pj.info) {
        int t = pi.info; pi.info = pj.info; pj.info = t;}
     }}
    }
	
//return the first Node which infor = given x otherwise return null
    public Node search(int x) 
    {Node p = head;
      while(p != null && p.info != x) p = p.next;
      return p;
	}
//delete the first node
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
	 
//remove a node from the list
    public void remove(Node p) 
    {if(p == null) return;
     //find q where q.next = p
     Node f = head, q = null;
     while(f != null && f != p) {q = f; f = f.next;}
     //remove head
     if(q == null) {head = head.next;
        if(head == null) tail = null;
     }else {q.next = p.next;
       if(p == tail) tail = q;
     }
     p.next = null;
    }

//reverse a list
    public void reverse() 
    {int n = size();
     for(int i = 0, j = n - 1; i < j; i ++, j --) {
      Node pi = get(i), pj = get(j);
      int t = pi.info; pi.info = pj.info; pj.info = t;}
    }