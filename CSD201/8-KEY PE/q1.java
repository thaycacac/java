/**
 *
 * @author Thaycacac
 */
public class q1 {
    //add last
    void addLast(Person x){
        Node q = new Node(x);
        if(isEmpty()){head=tail=q;return;}
        tail.next=q;tail=q;
    }
    //add first
    void addFirst(String xName, int xAge){
        if(xName.charAt(0)=='B') return;
        Person x=new Person(xName,xAge);
        addFirst(x);
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
    //sort by name
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
