
public class Dijkstra {
    
    int [][] a;
    int n;
    char [] vertext = "ABCDEFGHI".toCharArray();
    int INF = 99;
    
    public Dijkstra() {
     int [][] b = {
      //A  B  C  D  E  F 
      {0, 2, 5, 1, INF, INF},//A
      {2, 0, 3, 2, INF, INF},//B
      {5, 3, 0, 3, 1, 5},//C
      {1, 2, 3, 0, 1, INF},//D
      {INF, INF, 1, 1, 0, 2},//E
      {INF, INF, 5, INF, 2, 0},//F
     };
     a = b; n = a.length;
    }
    public void ijk(int u, int v) {
     boolean [] c = new boolean [n];//c[i] = true -> da chon dinh i
     int [] s = new int[n];//s[i] = j -> dinh truoc i la j
     int [] d = new int[n];//d[i] shortest path tu u den i
     for (int i = 0; i < n; i++) {
      s[i] = u;d[i] = a[u][i];
     }
     int curr = u; while(curr != v) {
     //tim k la dinh nho nhat xuat phat tu curr -> tim min tren mang d
     int k = -1, min = INF;
     for (int i = 0; i < n; i++) {
      if(d[i] < min && !c[i]) {
       min = d[i]; k = i;
      }
     }
     if(min == INF) {System.out.println("Shortest path from u to v not found");return;}   
     curr = k; c[k] = true;
     //tinh lai mang d
     for (int i = 0; i < n; i++) {
      if(d[i] > d[k] + a[k][i]) {
       d[i] = d[k] + a[k][i]; s[i] = k;
      }}
     }
     //output result
     System.out.println("Shortest path from u to v is " + d[v]);
     int [] h = new int[n]; int hn = 0; h[hn] = v;
     int [] w = new int[n];//w[i] trong so cua dinh i
     int wn = 0;//dem spt cua w
     int x, y = v;
     //tinh cac dinh tren duong di
     while(u != v) {
      v = s[v];h[++hn] = v;
     }
     //tinh trong so cac dinh tren duong di
     for (int i = hn; i >= 0; i --) {
      x = y; y = h[i]; w[wn] = a[x][y]; wn++;
     }
     //tinh trong so giua cac dinh tren duong di
     int k = 1;//khong hien thi trong so cua dinh dau tien
     System.out.print(vertext[h[hn]]);
     for(int i = hn - 1; i >= 0; i--) 
      System.out.print("->"+vertext[h[i]] + "(" + w[k++]+")");
      //hien thi tong trong so
      System.out.println("");
      System.out.print(vertext[h[hn]]);
      for(int i = hn - 1; i >= 0; i--)  System.out.print("->"+vertext[h[i]] + "(" + d[h[i]]+")");
    } 
}
