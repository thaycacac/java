public class Graph {
    
    int [][] a;//adjcency matrix
    int n;//total vertex
    char []vertex = "ABCDEFGHIJKLMN".toCharArray();
    
    public Graph() {
     int [][]b  = {
     //A  B  C  D  E  F  G  H  I
      {0, 1, 1, 1, 0, 0, 0, 0, 0}, //A
      {1, 0, 1, 1, 0, 0, 0, 0, 0}, //B 
      {1, 1, 0, 1, 0, 0, 0, 0, 0}, //C
      {1, 1, 1, 0, 0, 1, 0, 0, 0}, //D
      {0, 0, 0, 0, 0, 1, 0, 0, 0}, //E
      {0, 0, 0, 1, 1, 0, 0, 0, 0}, //F
      {0, 0, 0, 0, 0, 0, 0, 1, 1}, //G
      {0, 0, 0, 0, 0, 0, 1, 0, 0}, //H
      {0, 0, 0, 0, 0, 0, 1, 0, 0}  //I
     };
     a = b;
     n = a.length;
    }
    //visit vertex i
    public void visit(int i) {
     System.out.print(vertex[i] + "  ");
    }
    //Breadth first traversal
    public void BFT(int u, boolean []c) {
     MyQueue mq = new MyQueue();
     mq.enqueue(u); c[u] = true;
     while(!mq.isEmpty()) {
      int j = (int)mq.dequeue();
      visit(j);
      for (int i = 0; i < n; i++) {
       if(!c[i] && a[j][i] > 0) {
        mq.enqueue(i); c[i] = true;
       }}}
    }
    //Breath first traversal
    public void BFT(int u) {
     boolean []c = new boolean[n];
     BFT(u,c);
     for (int i = 0; i < n; i++) {
      if(!c[i]) BFT(i,c);
     }
    }
    //Depth first traversal
    public void DFT(int i, boolean []c) {
     c[i] = true; visit(i);
     for (int j = 0; j < n; j++) {
      if(!c[j] && a[i][j] > 0) DFT(j,c);
     }
    }
    public void DFT(int i) {
     boolean []c = new boolean[n];
     DFT(i,c);
     for (int j = 0; j < n; j++) {
      if(!c[j]) DFT(j,c);
     }}
    /*Session 1_______________________________________________________________*/
    //connectivity
    int [] tp; int con;
    public void conDFT(int i, boolean []c) {
     c[i] = true;
     tp[i] = con;
     for (int j = 0; j < n; j++) {
      if(!c[j] && a[i][j] > 0) conDFT(j,c);
     }}
    public void conDFT() {
     con = 0;
     tp = new int [n];
     boolean [] c = new boolean[n];
     for (int i = 0; i < n; i++) {
      if(!c[i]) {
       con ++; conDFT(i, c);
      }}
     //output connectivity
     System.out.println("Connectivity: " + con);
     for (int i = 1; i <= con; i++) {
      System.out.println("Connectivity = " + i);
      for (int j = 0; j < n; j++) {
       if(tp[j] == i) visit(j);
      }
     System.out.println("");
     }
    }
    
    //a path between u and v
    int u, v; int [] t; boolean found = false;
    public void pathDFT(int i, boolean []c) {
     c[i] = true;
     for (int j = 0; j < n; j++) {
      if(!c[j] && a[i][j] > 0) {
       t[j] = i;
       if(j == v) {
        found = true; return;
       }
       pathDFT(j, c);
      }}
    }
    public void pathDFT(int u, int v) {
     boolean [] c = new boolean[n];
     t = new int [n];
     this.u = u;
     this.v = v;
     pathDFT(u, c);
     if(found == false) 
      System.out.println("not found a path from " + vertex[u] + " to " + vertex[v]);
     else {
      System.out.println("a path from " + vertex[u] + " to " + vertex[v]);
      int [] h = new int[n];
      int hn = 0;
      h[0] = v;
      while(u != v) {
       v = t[v]; h[++hn] = v;
      }
      for (int i = hn; i >= 0; i--) {
       visit(h[i]);
       if(i > 0) System.out.print("->");
      }}
    }
    /*Session 2_______________________________________________________________*/
}
