package rotate;

public class Main {

    public static void main(String[] args) {
      int [] a = {7,5,8,2,6,1,4,3};
      BSTree t = new BSTree();
      t.insertMany(a);
      System.out.println("1. Test breadth-first traversal:");
      t.breadth(t.root);
      System.out.println();

      System.out.println("2. Test rotation  to right:");
      t.root = t.rotateRight(t.root);
      t.breadth(t.root);
      System.out.println();

      System.out.println();
    }
    
}

