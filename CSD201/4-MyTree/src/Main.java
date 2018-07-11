
public class Main {
    
    public static void main(String[] args) {
        
//        int [] x = {60, 90, 80, 100, 50, 55, 40};
//        BSTree tree = new BSTree();
//        for(int i = 0; i < x.length; i++) tree.insert(x[i]);
//        tree.preOrder(tree.root);//60 50 40 55 90 80 100
//        System.out.println("");
//        tree.inOrder(tree.root);//40 50 55 60 80 90 100
//        System.out.println("");
//        tree.BFT(tree.root);
//        System.out.println("");
/*Part 2___________________________________________________________________*/
        int [] x = {44, 17, 78, 32, 50, 88, 48, 62, 54};
        BSTree tree = new BSTree();
        for(int i = 0; i < x.length; i++) tree.insert(x[i]);
        tree.BFT(tree.root);
        System.out.println("");
        tree.balance(tree.root);
        tree.BFT(tree.root);
        System.out.println("");
/*Part 3___________________________________________________________________*/
    }
}
