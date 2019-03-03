
public class Main {

    public static void main(String[] args) {
     Graph g = new Graph();
     g.BFT(1);//A
     System.out.println("");
     /*Session 1_______________________________________________________________*/
     g.pathDFT(0, 6);//A->F
     System.out.println("");
     /*Session 2_______________________________________________________________*/
     Dijkstra d = new Dijkstra();
      d.ijk(0, 5);//A->F
      Euler e = new Euler();
      e.euler();
      System.out.println("");
    }
}
