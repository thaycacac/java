package traversal;

import java.util.*;
public class MyQueue {
   LinkedList<Integer> t;
   MyQueue() {
     t=new LinkedList<Integer>();  
   }
   void clear() {
     t.clear();  
   }
   boolean isEmpty() {
     return(t.isEmpty());  
   }
   void enqueue(Integer p) {
      t.addLast(p);
   }
   Integer dequeue() {
      if(isEmpty()) return(null);
      return(t.removeFirst());
   }
   Integer front() {
      if(isEmpty()) return(null);
      return(t.getFirst());    
   }
}

