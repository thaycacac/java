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

    void loadData(int k) //do not edit this function
    {
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
        f.writeBytes(" " + v[i]);
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

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================

    /*
    void f1Q — Perform depth first traversal (to the file f1.xt) from the vertex i=0 (the vertex A)
    but display only vertices having degree > 1. Hint: copy depth(...) to depth2(...) and modify
    the latter one. Content of the output file fl.txt must be:
    A E F I G B C H D
    A E F I G H
    */

    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(0, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(0, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
        void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        if (deg(k) > 1) {
            fvisit(k, f);
        }
        visited[k] = true;
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
    void f2() — Supposed the given graph has Euler's cycle. Apply the pseudocode in the
    Graph.java file to write statements to find the Euler's cycle from the vertex 2 (C). Write 2
    lines to the file f2.txt: the first line contains the Euler's cycle and the second line contains 3
    first vertices pushed into the stack (displayed by their pushing order). Output in the file
    f2.txt must be the following:
    C D E D B E G F A B C
    C B A
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
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f6.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f6.txt  
        eulerCycle(2, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void eulerCycle(int k, RandomAccessFile f) throws IOException {
        int[] eu = new int[100];
        int m, i, r;
        m = 0;
        Stack s = new Stack();
        Queue display = new Queue();
        s.push(k);
        display.enqueue(k);
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) { // r is isolated
                s.pop();
                eu[m++] = r;
            } else {
                s.push(i);
                display.enqueue(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        f.writeBytes(v[eu[0]] + "");
        for (i = 1; i < m; i++) {
            f.writeBytes("  " + v[eu[i]]);
        }
        f.writeBytes("\r\n");
        f.writeBytes(v[display.dequeue()] + "");
        f.writeBytes("  " + v[display.dequeue()]);
        f.writeBytes("  " + v[display.dequeue()]);
    }

}
//=================================================================
