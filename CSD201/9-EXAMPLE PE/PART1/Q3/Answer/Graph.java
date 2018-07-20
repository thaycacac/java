/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
class Graph
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
     f = new RandomAccessFile("graph.txt","r");
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

  void fbreadth(boolean [] en, int i, RandomAccessFile f) throws Exception
   {MyQueue q = new MyQueue();
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

  void fbreadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    fbreadth(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) fbreadth(en,i,f);
   }

  void fdepth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) fdepth(visited,i,f);
      }
   }
  void fdepth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    fdepth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) fdepth(visited,i,f);

   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
// DELETE FROM HERE
//--------------------------------------------------
  void calDegrees()
   {int i,j,t;
    for(i=0;i<n;i++)
      {t=0;
       for(j=0;j<n;j++) t += a[i][j];
       if(a[i][i]>0) t++;
       deg[i] = t;
      }
   }
  void fbreadthDeg(boolean [] visited, int k, RandomAccessFile f) throws Exception
   {MyQueue q = new MyQueue();
    int r,i;
    boolean [] enqueued = new boolean[20];
    for(i=0;i<n;i++) enqueued[i]=false;
    q.enqueue(k); enqueued[k]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      if(!visited[r]) {fvisitDeg(r,f);visited[r] = true;}
      for(i=0;i<n;i++)
       {if(!visited[i] && !enqueued[i] && a[r][i]>0) {q.enqueue(i);enqueued[i]=true;}
       }
     }
   }

  void fbreadthDeg(int  k, RandomAccessFile f) throws Exception
   {calDegrees();
    boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    fbreadthDeg(visited,k,f);
    for(i=0;i<n;i++) if(!visited[i]) fbreadthDeg(visited,i,f);
   }

  void fdepthDeg(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisitDeg(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) fdepthDeg(visited,i,f);
      }
   }
  void fdepthDeg(int k, RandomAccessFile f) throws Exception
   {calDegrees();
    boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    //f.writeBytes("\n Depth-first traverse from the vertex "<<v[k] <<": ";
    fdepthDeg(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) fdepthDeg(visited,i,f);

   }

  boolean isUndirected() // The adjacency matrix should be symmetric
   {int i,j;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++)
      if(a[i][j]!=a[j][i]) return(false);
    return(true);
   }

  boolean isEvenDegree()
   {int i,j,deg;
    for(i=0;i<n;i++)
     {deg=0;
      for(j=0;j<n;j++)
       deg+=a[i][j];
      if(deg%2==1) return(false);
     }
    return(true);
   }

  boolean isConnected()
   {boolean [] pushed = new boolean[20];
    boolean cont = false;
    int i, j, k, r;
    for(i=0;i<n;i++) pushed[i]=false;
    MyStack s = new MyStack();
    s.push(0); pushed[0] = true;
    while(!s.isEmpty())
      {r = s.pop();
       for(i=0;i<n;i++)
       {if(i==r) continue;
         if(!pushed[i] && a[r][i]>0) {s.push(i); pushed[i] = true;}
       }
     }
    for(i=0;i<n;i++) if(!pushed[i]) return(false);
    return(true);
   }

  int connectedParts()
   { boolean [] pushed = new boolean[20];
    boolean cont = false;
    int i, j, k, r;
    for(i=0;i<n;i++) pushed[i]=false;
    MyStack s = new MyStack();
    k=0;
    while(true)
     {s.clear();
      i = 0;
      while(i<n && pushed[i]) i++;
      if(i==n) break;
      s.push(i); pushed[i] = true;
      while(!s.isEmpty())
        {r = s.pop();
         for(i=0;i<n;i++)
          {if(i==r) continue;
           if(!pushed[i] && a[r][i]>0) {s.push(i); pushed[i] = true;}
          }
        }
       k++;
     }
    return(k);
   }

void dijkstra(int vFrom, int vTo, RandomAccessFile f) throws Exception // vFrom: from vertex, vTo: to vertex
  { int [] S = new int[20]; // the set S
    int [] dist = new int[20]; // current distances
    int [] path = new int[20]; // current path 
    boolean [] selected = new boolean[20];
    int m,i,k, t, INFI;INFI = 99;// 99 is considered infinity value
    //Khoi tao
    for(i=0;i<n;i++) 
       {selected[i]=false;
        dist[i]=a[vFrom][i]; // At the first step distance is a direct distance  
        path[i]=vFrom;       // and the vertex before vertex i is the vertex  vFrom
       }

    k=vFrom;// k is selected to the set S
    selected[k]=true; S[0] = vFrom;m=1; // add the vertex k the the S set
    while(k != vTo) //Thuc hien vong lap cho den khi gap nut vTo
       {t=INFI;k=-1;
        //Tim dinh gan nhat de dua vao tap  S
        for(i=0;i<n;i++)
          {if(selected[i]) continue;
           if(dist[i]<t) {t=dist[i];k=i;}
          }
        if(t==INFI) {f.writeBytes("\nKhong co duong di\r\n");return;}
        //Dua  dinh k vao tap S da xet
        selected[k]=true;S[m++] = k;
        //Tinh lai khoang cach
        for(i=0;i<n;i++)
           {if(selected[i]) continue;
            if(dist[i]>dist[k]+a[k][i])  {dist[i]=dist[k]+a[k][i]; path[i]=k;  }
           }
       } // end of while(k != vTo) 

    MyStack  u = new MyStack();
    f.writeBytes("\n\n The length of shortest path from " + v[vFrom] + " to  " + v[vTo] + " is  " + dist[vTo] +"\r\n");
    f.writeBytes("\n Path:\r\n");
    i=vTo;
    u.push(i);
    do
       {i=path[i];
        u.push(i);
       }
    while(i!=vFrom);

    int x, y;
    y = u.pop();
    while(!u.isEmpty())
     {x=y;
       y= u.pop();
       f.writeBytes("" + v[x]); 
       f.writeBytes(" -> (" + a[x][y] + ")");
     }
    f.writeBytes("" + v[y] + "\r\n"); 
  }

 void checkEulerCycle(RandomAccessFile f) throws Exception
   {if(isUndirected())
      f.writeBytes("The graph is undirected.\r\n");
       else
         f.writeBytes("The graph is directed.\r\n");
    if(isConnected())
      f.writeBytes("The graph is connected.\r\n");
       else
         f.writeBytes("The graph is not connected.\r\n");

    if(isEvenDegree())
      f.writeBytes("All vertices have even degree.\r\n");
       else
         f.writeBytes("The graph has a vertex with odd degree.\r\n");
    if(isUndirected() && isConnected() && isEvenDegree())
      f.writeBytes("Conditions for Euler's cycle are satisfied.\r\n");
        else
         f.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");
      
   }
 
void EulerCycle(int k, RandomAccessFile f) throws Exception
   {if(!isUndirected() || !isConnected() || !isEvenDegree())
      {f.writeBytes("Conditions are not satisfied\r\n");
       return;
      }
    MyStack  s = new MyStack();
    int [][] b = new int[20][20];
    int [] eu = new int[20]; int m;
    int i,j,r;
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) b[i][j]=a[i][j];
    s.push(k);//Dua dinh k vao Stack
    m = 0;//Ban dau chu trinh chua co phan tu nao
    while(!s.isEmpty())
      {r = s.top();
       i=0;
       while(i<n && b[r][i]==0) i++;//Tim i dau tien de b[r][i]#0
       if(i==n) //r da la dinh co lap, dua  r  vao chu trinh Euler
         {eu[m++] = r; s.pop();}//Lay dinh co lap ra khoi Stack
         else
          {s.push(i);b[r][i]--;b[i][r]--;}//Loai canh (i,r) khoi do thi
      }
    // Display Euler cycle
    for(i=0;i<m;i++) f.writeBytes(v[eu[i]] + "  ");
    f.writeBytes("\r\n");
   }


// (DELETE) TO HERE

//=================================================================
  void f1() throws Exception
   {loadData(10);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fbreadth(0,f123);// fbreadth first traverse from the vertex 0 (A)
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


    //-------------------------------------------------------------------------------------
    fbreadthDeg(0,f123);// fbreadth first traverse from the vertex 0 (A)
    //--------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void f2() throws Exception
   {loadData(10);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdepth(0,f123);// fdepth first traverse from the vertex 0 (A)
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


    //-------------------------------------------------------------------------------------
    fdepthDeg(0,f123);// fdepth first traverse from the vertex 0 (A)
    //--------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void f3() throws Exception
   {loadData(21);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdispAdj(f123);
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


    //-------------------------------------------------------------------------------------
    int k = connectedParts();
    f123.writeBytes("k = " + k + "\r\n"); 
    //--------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void f4() throws Exception
   {loadData(33);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


    //-------------------------------------------------------------------------------------
    int vFrom, vTo; 
    vFrom = 0; // The vertex A
    vTo = 5; // The vertex F
    dijkstra(vFrom, vTo, f123);
    //--------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void f5() throws Exception
   {loadData(42);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


    //-------------------------------------------------------------------------------------
    checkEulerCycle(f123);
    loadData(49); 
    f123.writeBytes("\r\n");
    checkEulerCycle(f123);
    //--------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
  void f6() throws Exception
   {loadData(42);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/


    //-------------------------------------------------------------------------------------
    EulerCycle(0,f123);
    //--------------------------------------------------------
    f123.writeBytes("\r\n");
    f123.close();
   }

}
//=================================================================
