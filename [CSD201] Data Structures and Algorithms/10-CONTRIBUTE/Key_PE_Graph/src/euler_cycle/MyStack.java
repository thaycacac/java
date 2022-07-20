package euler_cycle;

import traversal.*;
import java.util.*;
public class MyStack {
   LinkedList<Integer> t;
   MyStack() {
     t=new LinkedList<Integer>();  
   }
   void clear() {
     t.clear();  
   }
   boolean isEmpty() {
     return(t.isEmpty());  
   }
   void push(Integer p) {
      t.addLast(p);
   }
   Integer pop() {
      if(isEmpty()) return(null);
      return(t.removeLast());
   }
   Integer top() {
      if(isEmpty()) return(null);
      return(t.getLast());    
   }
}

