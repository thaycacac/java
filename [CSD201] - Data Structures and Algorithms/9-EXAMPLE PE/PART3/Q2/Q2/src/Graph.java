/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
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

  void fvisitDeg(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]+"("+deg[i]+")");
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

  void breadth(boolean [] visited, int k, RandomAccessFile f) throws Exception
   {GQueue q = new GQueue();
    int r,i;
    boolean [] enqueued = new boolean[20];
    for(i=0;i<n;i++) enqueued[i]=false;
    q.enqueue(k); enqueued[k]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      if(!visited[r]) {fvisit(r,f);visited[r] = true;}
      for(i=0;i<n;i++)
       {if(!visited[i] && !enqueued[i] && a[r][i]>0) {q.enqueue(i);enqueued[i]=true;}
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    breadth(visited,k,f);
    for(i=0;i<n;i++) if(!visited[i]) breadth(visited,i,f);
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
   int countf5 = 0;
  void depthf5(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {
    if(countf5 < 5){
        fvisit(k,f);
        countf5++;
    }
    visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depthf5(visited,i,f);
      }
   }
  void depthf5(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depthf5(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depthf5(visited,i,f);

   }
  
  void f5() throws Exception
   {loadData(10);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    depth(0,f);
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       depthf5(0, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

//=================================================================
    char [] vertex;
  void ijkf6(int u, int v, RandomAccessFile f123) throws Exception {  // Ghi vao file nen phai them
        vertex = this.v;       // Them cai nay nua mmoi dung
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
            int INF = 999;                                   // Nho la INF = 99
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
        
        int []h = new int[n];
        int hn = 0;
        h[hn] = v;
        int x, y = v;
        while(u != v) {
            v = t[v];
            h[++hn] = v;
        }
        int [] w = new int[n];
        int wn = -1;
        for(int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 1;
        f123.writeBytes("\r\n"+d[h[0]]);
        f123.writeBytes("\r\n");
        w[0] = 0;
        for (int i = 0; i <= 3; i++) {
            f123.writeBytes(vertex[t[i]]+" "); 
        }
        f123.writeBytes("\r\n");    
        for(int i = hn; i >= hn-3; i--){
            f123.writeBytes(d[h[i]]+" "); 
        }
  }
  void f6() throws Exception
   {loadData(21);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    int k123 = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       ijkf6(1, 5, f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

}
//=================================================================
