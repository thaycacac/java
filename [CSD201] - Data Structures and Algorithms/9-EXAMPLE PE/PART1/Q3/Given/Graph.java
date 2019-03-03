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
    f123.writeBytes("\r\n");
    f123.close();
   }

//=================================================================
void checkEulerCycle(RandomAccessFile  f123)
 {
 }

  void f5() throws Exception
   {//You do not need to edit this file
    //Your task is to complete the checkEulerCycle(...) function above only
    loadData(42);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 

    checkEulerCycle(f123);
    loadData(49); 
    f123.writeBytes("\r\n");
    checkEulerCycle(f123);

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
    f123.writeBytes("\r\n");
    f123.close();
   }

}
//=================================================================
