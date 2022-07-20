// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Node {
  Bat info;
  Node next;
  Node() {
   }
  Node(Bat x, Node p) {
    info=x;next=p;
   }
  Node(Bat x) {
    this(x,null);
   }
 }

