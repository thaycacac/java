package traversal;

public class Main {

    public static void main(String[] args) {
        int[][] b = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0}
        };
        Graph g = new Graph();
        g.setData(b);
        g.dispAdj();
        System.out.println();
        System.out.println("1. Test breadth-first traversal:");
        g.breadth(0);
        System.out.println();
        System.out.println("2. Test depth-first traversal:");
        g.depth(0);
        System.out.println("\n");

    }

}
