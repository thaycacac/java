/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
public class Graph
 {int [][] a; int n;
  char v[];
  int deg[];
  Graph()
    {v = "ABCDEFGHIJKLMNOP".toCharArray();
     deg = new int[20];
     a = new int[20][20];
     n = 0;
    }

  void loadData(int k)  //do not edit this function
   {RandomAccessFile f;int i,j,x;
    String s;StringTokenizer t;
    a = new int[20][20];
    try {
     f = new RandomAccessFile("data.txt","r");
     for(i=0;i<k;i++) f.readLine();
     s = f.readLine();s = s.trim();
     n = Integer.parseInt(s);
     for(i=0;i<n;i++)
       {s = f.readLine();s = s.trim();
        t = new StringTokenizer(s);
        for(j=0;j<n;j++) 
          {x = Integer.parseInt(t.nextToken().trim());
           a[i][j] = x;
          }
       }
     f.close();
     }
    catch(Exception e) {}

   }

  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
   }

  void fvisit(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]);
   }

 void fdispAdj(RandomAccessFile f) throws Exception 
   {int i,j;
    f.writeBytes("n = "+n+"\r\n");
    for(i=0;i<n;i++)
     {f.writeBytes("\r\n");
      for(j=0;j<n;j++)  f.writeBytes("  " + a[i][j]);
     }
    f.writeBytes("\r\n");
   }

  void breadth(boolean [] en, int i, RandomAccessFile f) throws Exception
   {GQueue q = new GQueue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisit(r,f);
      for(j=0;j<n;j++)
       {if(!en[j] && a[r][j]>0) {q.enqueue(j);en[j]=true;}
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    breadth(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) breadth(en,i,f);
   }

 void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth(visited,i,f);
      }
   }
  void depth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void f5() throws Exception
   {loadData(13);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       dijkstra(0, 4, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }
   void ijk(int u, int v, RandomAccessFile f123) throws Exception {
        char[] vertex = this.v;       // Them cai nay nua mmoi dung
        //d[i] shortest path from u to i
        int [] d = new int[n];
        //t[i]= j -> before vertex i is j
        int []t = new int[n];
        //c[i] = true -> vertex i is selected
        boolean []c = new boolean[n];
        //step 0
        for (int i = 0; i < n; i++) {
            d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while(curr != v) {
            //tim k la dinh ma chi phi tu u den k la nho nhat
            //tim min tren mang d
            int INF = 999; 
            int k = -1, min = INF;
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min) {
                    min = d[i];k = i;
                }
            }
            if(min == INF) {
                System.out.println("Shortest path does not exists");
                return;
            }
            //chon dinh k la dinh ke tiep
            c[k] = true;curr = k;
            //tinh lai d va t
            for (int i = 0; i < n; i++) {
                if(d[i] > d[k] + a[k][i] && !c[i]) {
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        //tim duong di tu v den u
//        f123.writeBytes("The length of Shortest path from " + vertex[u] + "to "
//        + vertex[v] + " is " + d[v]); //
        int []h = new int[n];
        int hn = 0;
        h[hn] = v;
        int x, y = v;
        while(u != v) {
            v = t[v];
            h[++hn] = v;
        }
        //hien thi trong so moi buoc di
        int [] w = new int[n];
        int wn = -1;
        for(int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 1;//khong hien thi trong so dinh dau tien (u)
        f123.writeBytes("\r\n"+vertex[h[hn]]);                               // No yeu cau string 
        for (int i = hn - 1; i >= 0; i--) {
            // d[h[i]] // Hien thi cac dinh va trong so cua no 
            f123.writeBytes("->("+w[k++]+")" + vertex[h[i]]);  //
        }
        f123.writeBytes("\r\n");    // Xuong dong cua file no khac
    }
   
   void dijkstra(int fro, int to, RandomAccessFile f) throws IOException {
    boolean [] S = new boolean[n];
    int [] d = new int[n];
    int [] p = new int[n];
    int INF = 999;
    int i,j,k, t;
    for(i=0;i<n;i++) {
      S[i] = false;
      d[i] = a[fro][i];
      p[i] = fro;
    }
    S[fro] = true;
    while(true) {
      // find d[k] = min {d[i}}
      t = INF; k=-1;
      for(i=0;i<n;i++) {
        if(S[i]==true) continue;
        if(d[i]<t) {
          t = d[i];
          k = i;
        }
      }
      if(k==-1) {
        return;
      }
      // add k to S
      S[k] = true;
      if(k==to) break;
      // update d[i] & p[i]
      for(i=0;i<n;i++) {
       if(S[i]==true) continue;
       if(d[i] > d[k] + a[k][i]) {
          d[i] = d[k] + a[k][i];
          p[i] = k;
        }
      }
    }
//    System.out.println("The shortest distance is " + d[to]);
    i = to;
    GStack s = new GStack();//store vertex
    ArrayList points = new ArrayList();//store distance
    while(true) {
      s.push(i);
      if(i==fro) break;
      i = p[i];
    }
//print line 1: vertex, line2 : distance

    while(!s.isEmpty()) {
      i = s.pop();
      points.add(i);
    }
    for (int l = 0; l < points.size(); l++)  f.writeBytes(v[l]+" ");//print vertex
    f.writeBytes("\n");
    for (int l = 0; l < points.size(); l++)   f.writeBytes(d[(int)points.get(l)]+ " ");//print distance
    f.writeBytes("\n");
    
//print (0)A->(9)C->(2)F->(9)E
//    for (int l = 0; l < points.size()-1; l++)  f.writeBytes("("+d[(int)points.get(l)]+")"+v[l]+" "+"->");//then delete last ->
//    f.writeBytes("("+d[(int)points.get(points.size()-1)]+")"+v[points.size()-1]+" ");
//    f.writeBytes("\n");
  }

//=================================================================
/*
Algorithm for finding an Euler cycle from the vertex X using stack 
//Input: Connected graph G with all vertices having even degrees
//Output: Euler cycle
declare a stack S of characters
declare empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {r = top element of the stack S 
  if r is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to r, push  Y  to  S and remove the edge (r,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
*/
  void f6() throws Exception
   {loadData(21);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
      //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  

      eulerCycle(1, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }
  int deg(int i) {
     int s,j;
     s=0;
     for(j=0;j<n;j++) s += a[i][j];
     s += a[i][i];
     return(s);
  }
  boolean hasIsolated() {
    for(int i=0;i<n;i++) 
      if(deg(i)==0) return(true);
    return(false);
  }
  boolean isConnected() {
    boolean [] p = new boolean[n];
    int i,j,r;
    for(i=0;i<n;i++) p[i]=false;
    GStack s = new GStack();
    s.push(0); p[0] = true;
    while(!s.isEmpty()) {
      r = s.pop();
      for(i=0;i<n;i++)
        if(!p[i] && a[r][i]>0) {
          s.push(i); p[i]=true;  
        }  
    }
    for(i=0;i<n;i++)
        if(!p[i]) return(false);
    return(true);
  }
  boolean isUnDirected() {
    int i,j;
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        if(a[i][j] != a[j][i]) return(false);
    return(true);
  }
  boolean allDegEven() {
    for(int i=0;i<n;i++)
      if(deg(i)%2 == 1) return(false);
    return(true);
  }
  boolean hasEulerCycle() {
    if(!hasIsolated() && isUnDirected() && isConnected() && allDegEven())
       return(true);
      else
        return(false);
  }
  void eulerCycle(int fro, RandomAccessFile f) throws IOException {
    if(!hasEulerCycle()) {
      return;
    }
    int [] eu = new int[100];
    int m,i,j,r;
    GStack s = new GStack();
    s.push(fro);
    j=0;
    while(!s.isEmpty()) {
      r = s.top();
      for(i=0;i<n;i++) {
        if(a[r][i] > 0) break;  
      }
      if(i==n) { //r is isolated
        s.pop();
        eu[j++] = r;
          
      }
      else {
       s.push(i);
       a[r][i]--;
       a[i][r]--;
      }
    }
    m = j;
    for(i=0;i<m;i++) {
        f.writeBytes(v[eu[i]]+" ");
    }
  }

}
//=================================================================
