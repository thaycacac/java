/**
 *
 * @author Thaycacac
 */
 
 /*Table content to search*/
 
 ||____ADD______//add last
 ||	||______//add first
 ||     ||______//add many
 ||     ||______//add if age > 4
 ||     ||______//add element have max age
 ||
 ||___INSERT____//insert position k
 ||       ||____//insert after position k
 ||
 ||___SEARCH____//search node
 ||       ||____//search node with string
 ||       ||____//search node with integer/double
 ||
 ||___DELETE____//delete node
 ||       ||____//delete all
 ||       ||____//delete at position k
 ||       ||____//delete first no age < 6
 ||       ||____//delete a node after position k
 ||       ||____//delete node after 2 node have age < 9
 ||       ||____//delete node thirdth have age < 6
 ||       ||____//delete node first after node have position k
 ||       ||____//delete node after node have price > xPrice
 ||       ||____//delete 2 node last have age > 5
 ||       ||____//delete second biggest
 ||
 ||___SORT______//sort by string
 ||     ||______//sort by integer/ double
 ||     ||______//sort by for
 ||     ||______//sort 3 first element 
 ||
 ||___SWAP______//swap min max
 ||     ||______//swap node max second with node min first
 ||
 ||___GET_______//get node at index k
 ||    ||_______//get node max
 ||
 ||___ORTHER____//traverse
 ||       ||____//replace a node
 ||       ||____//count number of node
 ||       ||____//reverse list
 ||       ||____//append another list
 ||       ||____//change name first

 
 
//add last
    public void addLast(Person x){
        Node q = new Node(x);
        if(isEmpty()){head=tail=q;return;}
        tail.next=q;tail=q;
    }
	
//add first
    public void addFirst(Person x){
		Node p = new Node(x);
		if(isEmpty()) {head = tail = p;}
		else {p.next = head; head = p;}
    }
	
//add many
	public void addMany(String [] a, int [] b){
		int n,i; n=a.length;
		for(i=0;i<n;i++) addLast(new Person(a[i],b[i]));
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
    public void addMaxAgeInH(){
		Person k = getMaxColor();
		Node p = head;
		while(p != null){
			if(p.info.age == k.age) h.addLast(p.info);
			p = p.next;
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
            addFirst(c); return;
        }
        int count = 0;
        Node p1 = head;
        while(p1 != null && count < k){
            p1 = p1.next; count++;
        }
        if(p1.next == null && count == k){
            addLast(c); return;
        }
        p.next = p1.next;
        p1.next = p; 
    }
	
//search node
	public Node search(int x{
		Node p = head;
		while(p != null && p.info != x) p = p.next;
		return p;
	}
	
//search node with string
	public Node search(String colorName){
        Node p = head;
        while(p != null){
            if(p.info.name.equalsIgnoreCase(colorName)){
                break;
            }
            p = p.next;
        }
        return p;
	}
	
//search node with integer/double
	public Node search(int xAge){
		Node p=head;
		while(p!=null){
			if(p.info.age == xAge) return(p);
			p=p.next;
        }
		return(null);
     }
	
//delete node
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
	 
//delete all
	public void deleAll(int xAge){
		Node q;
		while(true){
			q = searchByAge(xAge);
			if(q==null) break;
			dele(q);
		}   
    }
	 
//delete at position k
	public void deleteAt(int k) {
        if (isEmpty()) return;
        if (k == 0) {//check if node is head
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            Node p = getNode(k);//get node position k
            if (p == null) return;
            Node q = getNode(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) tail = q;
        }
    }

//delete first no age < 6
    public void deleteFirstCondition(){
		Node p = head;
		while(p != null){
			if(p.info.age<6) dele(p);
			p=p.next;
		}
    }
	
//delete a node after position k
    public void deleteAfterPosK(int k){
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
	
//delete node after 2 node have age < 9
	public void deleteAfterTwoNodeAgeSmallerNine(){
		Node p = head;
		while(p != null && p.info.age >= 9){
			p = p.next;
		}
		if(p == null && p.next == null){
			return;
		}
		remove(p.next.next);
	}
	
//delete node thirdth have age < 6
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
	
//delete node first after node have position k
	public void deleteFirstAfterPosition(int k){
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
	
//delete node after node have price > xPrice
	public void deleteAfterCondition(double xPrice){
		Node p = head;
		while (p != null && p < xPrice) {
			p = p.next;
		}
		if (p == null || p.next == null) return;
		Node q = p.next;
		if (q == tail) tail = p;
		p.next = q.next;
		q.next = null;
	}

//delete 2 node last have age > 5
	public void removeTwoLastNodeCondition(){
		int c = 0; int sz = size();
		for(int i = sz - 1; i >= 0; i--){
			Node p = getNode(i);
			if(p.info.age > 5){
				c++;
				remove(p);
            if(c >= 2) break;
			}
		}
    }
	
//delete second biggest
	public void removeSecond() {
        Person firstMax = getMaxColor();
        if(firstMax == null) return;
        int n = size();
        if(n <= 1 ) return;
        int imax = 0; Node p = head;
        while(p != null && p.info.age == firstMax.age){
            imax++;
            p = p.next;
        }
        // Find second max starting from imax
        Person secondMax = (p != null) ? p.info : null;
        for (int i = imax + 1; i < n; i++) {
            Node pi = getNode(i);
            if(pi.info.age > secondMax.age && pi.info.age != firstMax.age){
                imax = i;
                secondMax = pi.info;
            }
        }
        if(imax < n) remove(imax);
    } 
	 
//sort by string
    public void sort(){
		Node pi,pj; Person x;
		pi=head;
		while(pi!=null){
			pj=pi.next;
			while(pj!=null){
				if(pj.info.name.compareTo(pi.info.name)<0){
					x=pi.info;pi.info=pj.info;pj.info=x;
				}
				pj=pj.next;
			}
			pi=pi.next;
		}
    }
	
//sort by integer/ double
	public void sort() {
		Node pi,pj; Car x;
		pi=head;
		while(pi!=null){
			pj=pi.next;
			while(pj!=null){
				if(pj.info.price<pi.info.price){
					x=pi.info;pi.info=pj.info;pj.info=x;
				}
				pj=pj.next;
			}
			pi=pi.next;
		}
    }
	
//sort by for
	public void sortByFor(){
		int n = (size() > 3) ? 3 : size();
			int n = size();         
    // for(int i = n-3; i < n; i++) //last 3 element
    // for(int j = i+1; j < n; j++) //first 3 element
		for(int i = 0; i < n - 1; i++){   
			for(int j = i+1; j < n; j++){
				Node pi = getNode(i);
				Node pj = getNode(j);
				if(pi.info.name.compareToIgnoreCase(pj.info.name) > 0){
					Person temp = pi.info;
					pi.info = pj.info;
					pj.info = temp;
				}
			}
		}
	}
	
//sort 3 first element 
	public void sortThird() {
        Node pi, pj; pi = head; int count = 0; 
        while(pi != null) {
            count++; pj = pi.next; int count1 = 0;
            while(pj != null) {
                count1++;
                if(pi.info.name.compareToIgnoreCase(pj.info.name) < 0) {
                    Person t = pi.info; pi.info = pj.info;pj.info = t;
                }
                pj = pj.next; if(count1 == 3 - count) break;
            }
            pi = pi.next; if(count == 2) break;
        }
    }
	
//swap min max
	public void swapMinMax(){
		Node min = getMin();
		Node max = getMax();       
        Person t = min.info;
        min.info = max.info;
        max.info = t;
	}
	
//swap node max second with node min first
	public void swapMax2Min1(){
		Node max = getMax();
		Node min = getMin();
		Node p = head;
		int count = 0;
		while(p != null){
			if(p.info.age == max.info.age) count++;
			if(count == 2) break;
			p = p.next;
		}
		Person temp;
		temp = p.info;
		p.info = min.info;
		min.info= temp;
	}
     
//get node at index k
	public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }
	
//get node max
	public Person getMaxPerson(){
        if(isEmpty()) return null;
        Person max = head.info;                
        Node p = head;
        while( p != null){
            if(p.info.age > max.age) max = p.info;
            p = p.next;
        }
        return max; 
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

//replace a node
	public void replace{
	    Node p = head;
        while(p != null){
            if(p.info.name.equals("xName")){// xName was given
                 break;
            }
            p = p.next;
        }
         if(p != null){                       
              p.info.name = yName;// yName was given
        }
	}
	
//count number of node
	int count(Node p)
	 {if(p==null) return(0);
	   int k,h,r;
	   k = count(p.left);
	   h = count(p.right);
	   r = k+h+1;
	   return(r);
	 }
	
//reverse list
	public void reverse() {
        int n = size(), i, j;
        for (i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);// create a node = getnode index i
            Node pj = getNode(j);// create a node = getnode index j
            Person temp = pi.info;// Note: change value of node, not change node
            pi.info = pj.info;
            pj.info = temp;
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
	
//change name first
    void changeNameFirst(){
      Node p=head;
        while(p!=null)
         {if(p.info.name.equals("C6")) {p.info.name="CX";break;}
           p=p.next;
         }
	}
}



