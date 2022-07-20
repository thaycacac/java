package euler_cycle;

public class Graph {

    int[][] a;
    int n;
    char[] v;

    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        int i, j;
        n = b.length;
        a = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
        }
        System.out.println();
    }

    void visit(int i) {
        System.out.print(v[i] + "  ");
    }

    void breadth(boolean[] en, int i) {
        MyQueue q = new MyQueue();
        q.enqueue(i);
        en[i] = true;
        int j, r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[i][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k) {
        boolean[] en = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i);
            }
        }
    }

    void depth(boolean[] vis, int i) {
        visit(i);
        vis[i] = true;
        int j;
        for (j = 0; j < n; j++) {
            if (!vis[j] && a[i][j] > 0) {
                depth(vis, j);
            }
        }
    }

    void depth(int k) {
        boolean[] vis = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            vis[i] = false;
        }
        depth(vis, k);
        for (i = 0; i < n; i++) {
            if (!vis[i]) {
                depth(vis, i);
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

    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }

    boolean isConnected() {
        MyStack s = new MyStack();
        boolean[] p = new boolean[n];
        int i, r;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(0);
        p[0] = true;
        while (!s.isEmpty()) {
            r = s.pop();
            for (i = 0; i < n; i++) {
                if (!p[i] && a[r][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]) {
                return (false);
            }
        }
        return (true);
    }

    boolean hasEulerCycle() {
        if (allDegEven() && isConnected()) {
            return (true);
        } else {
            return (false);
        }
    }

    void eulerCycle(int k) {
        if (!hasEulerCycle()) {
            System.out.println("Condicitons for Euler's cycle are not satisfied");
            return;
        }
        int[] eu = new int[100];
        int m = 0;
        int i, j, r;
        MyStack s = new MyStack();
        s.push(k);
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) { // r isolated
                s.pop();
                eu[m++] = r;
            } else {
                s.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        System.out.println("Euler's cycle is:");
        System.out.print(v[eu[0]]);
        for (i = 1; i < m; i++) {
            System.out.print(" -> " + v[eu[i]]);
        }
        System.out.println();
    }

}
