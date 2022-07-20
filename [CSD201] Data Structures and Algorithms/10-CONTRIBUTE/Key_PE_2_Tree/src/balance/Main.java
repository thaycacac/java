package balance;

public class Main {

    public static void main(String[] args) {
      int [] a = {6,5,7,1,8,3,2,4};
      BSTree t = new BSTree();
      t.insertMany(a);
      System.out.println("1. Test breadth-first traversal:");
      t.breadth(t.root);
      System.out.println();

      System.out.println("2. Test simple balancing:");
      t.bal();
      t.breadth(t.root);
      System.out.println();

      System.out.println();
    }
    
}

