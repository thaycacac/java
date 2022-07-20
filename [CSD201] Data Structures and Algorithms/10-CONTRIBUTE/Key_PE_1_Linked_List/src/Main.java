public class Main
 {public static void main(String [] args)
   { MyList t = new MyList();
     Node p,q; Person x; int k;
     String [] a = {"A","C","B","E","D"};
     int [] b = {9,5,17,5,8};
 
     System.out.println("\n1. Test addLast");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
 
     System.out.println("\n2. Test searchByName");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
     p = t.searchByName("B");
     if(p==null)
      System.out.println("Not found");
      else
      {System.out.println("The person found is");
        t.visit(p); System.out.println();
      }

     System.out.println("\n3. Test addFirst");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
     x = new Person("X",30);
     t.addFirst(x);  
     t.traverse(); // (X,30) (A,9) (C,5) (B,17) (E,5) (D,8)

     System.out.println("\n4. Test insertAfter");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     x = new Person("X",30);
     q = t.searchByName("B");
     t.insertAfter(q,x);  
     t.traverse(); // (A,9) (C,5) (B,17) (X,30) (E,5) (D,8)

     System.out.println("\n5. Test insertBefore");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     x = new Person("X",30);
     q = t.searchByName("B");
     t.insertBefore(q,x);  
     t.traverse(); // (A,9) (C,5) (X,30) (B,17) (E,5) (D,8)

     System.out.println("\n6. Test remove(Node q)");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     q = t.searchByName("B");
     t.remove(q);  
     t.traverse(); // (A,9) (C,5) (E,5) (D,8)

     System.out.println("\n7. Test remove(String xName)");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.remove("B");  
     t.traverse(); // (A,9) (C,5) (E,5) (D,8)

     System.out.println("\n8. Test remove(int xAge)");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.remove(5);  
     t.traverse(); // (A,9) (B,17) (E,5) (D,8)

     System.out.println("\n9. Test removeAll(int xAge)");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.removeAll(5);  
     t.traverse(); // (A,9) (B,17) (D,8)

     System.out.println("\n10. Test pos(int k)");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     p = t.pos(2);
     System.out.println("The person at position 2 is ");
     t.visit(p); // The person at position 2 is  (B,17)
     System.out.println();

     System.out.println("\n11. Test removePos(int k)");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.removePos(2);  
     t.traverse(); // (A,9) (C,5) (E,5) (D,8)

     System.out.println("\n12. Test sortByName()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.sortByName();
     t.traverse(); // (A,9) (B,17) (C,5) (D,8) (E,5)

     System.out.println("\n13. Test sortByAge()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.sortByAge();
     t.traverse(); // (C,5) (E,5) (D,8) (A,9) (B,17)

     System.out.println("\n14. Test size()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     k = t.size();
     System.out.println("Size = " + k);  

     System.out.println("\n15. Test toArray()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     Person [] u = t.toArray();
     if(u!=null)
      {for(int i=0;i<u.length;i++) 
               System.out.print(u[i]); // (A,9) (C,5) (B,17) (E,5) (D,8)
        System.out.println();
      }

     System.out.println("\n16. Test reverse()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     t.reverse();
     t.traverse(); // (D,8) (E,5) (B,17) (C,5) (A,9)

     System.out.println("\n17. Test findMaxAge()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     p = t.findMaxAge();
     System.out.println("The person with maximum age:");
     t.visit(p);
     System.out.println();

     System.out.println("\n18. Test findMinAge()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     p = t.findMinAge();
     System.out.println("The person with minimum age:");
     t.visit(p);
     System.out.println();

     System.out.println("\n19. Test setData()");
     t.clear();
     t.addMany(a,b);  
     t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
     p = t.searchByName("B");
     x = new Person("XX",99);
     t.setData(p,x);
     t.traverse(); // (D,8) (E,5) (XX,99) (C,5) (A,9)

     String [] c = {"A","B","C","D","E","F","G","H","I"};
     int [] d = {9,8,7,6,15,4,3,2,1};
     System.out.println("\n20. Test sortByAge(3, 6)");
     t.clear();
     t.addMany(c,d);  
     t.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
     t.sortByAge(3,6);
     t.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (D,6) (E,15) (H,2) (I,1) 

     System.out.println("\n21. Test reverse(3, 6)");
     t.clear();
     t.addMany(c,d);  
     t.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
     t.reverse(3,6);
     t.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (E,15) (D,6) (H,2) (I,1) 

     System.out.println();  
   }
 }
