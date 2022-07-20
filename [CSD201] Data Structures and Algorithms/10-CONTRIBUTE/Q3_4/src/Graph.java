/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    
    /*
    void f1() - Perfom depth-first traversal (to the file fl.xt) from the vertex i=1 (the vertex B)
    but display vertices with their deegrees in bracket. Hint: copy depth(...) to depth2(...) and
    modify the latter one. Content of the output file fl.txt must be:
    B G A E F I C H D
    B(1) G(2) A(4) E(3) F(3) I(3) C(1) H(2) D(1)
    */

    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(3, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        depth2(3, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    int count = 1;

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (count >= 2 && count <= 6) {
            fvisit(k, f);
        }
        visited[k] = true;
        count++;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

//=================================================================
    
    /*
    void f2() — Apply the Dijkstra’s shortest path algorithm to find the shortest path from the
    vertex 0 (A) to the vertex 4 (E). (Note that in the weighted matrix, the value 999 is
    considered as infinity). Write 2 lines into the file f6.txt. The first line contains the list of
    vertices in the shortest path. The second lines contains shortest distances to the vertices in
    the first line. Content of the output file f2.txt must be:
    A C F E
    0 9 11 20
    */
    
    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        
        dijkstra(2, 5, f);
        f.writeBytes("\r\n");
        dijkstra(0, 6, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void dijkstra(int u, int z, RandomAccessFile f) throws IOException, Exception {

        boolean[] c = new boolean[n];
        int[] t = new int[n];
        int INF = 99;
        for (int i = 0; i < n; i++) {
            deg[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while (curr != z) {
            int min = INF;
            int k = -1;
            for (int i = 0; i < n; i++) {
                if (!c[i] && deg[i] < min) {
                    min = deg[i];
                    k = i;
                }
            }
            if (min == INF) {
                System.out.println("Sortest path does not exists");
                return;
            }
            c[k] = true;
            curr = k;
            for (int i = 0; i < n; i++) {
                if (deg[i] > deg[k] + a[k][i] && !c[i]) {
                    deg[i] = deg[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        int[] h = new int[n];
        int hn = 0;
        h[hn] = z;
        int x, y = z;
        while (u != z) {
            z = t[z];
            h[++hn] = z;
        }
        int[] w = new int[n];
        int wn = -1;
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 0;
        for (int i = hn; i >= 0; i--) {
            f.writeBytes(v[h[i]] + " ");
        }
        f.writeBytes("\n");
    }

}
