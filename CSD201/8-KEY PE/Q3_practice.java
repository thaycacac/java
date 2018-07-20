//visit vertex i
	void visit(int i) {
        System.out.print(vertex[i] + " ");
    }
	
//breadth first traversal
    void bfs(int i, boolean []c) {
        MyQueue m = new MyQueue();
        m.enqueue(i);
        c[i] = true;
        while(!m.isEmpty()) {
            int k = (int)m.dequeue();
            for (int j = 0; j < n; j++) {
                if(!c[j] && a[k][j] > 0) {
                    m.enqueue(j);
                    c[j] = true;
                }
            }
            visit(k);
        }
    }
	//use breadth first traversal
	void bfs() {
        boolean [] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]) bfs(i,c);
        }
    }
	
//dept first traversal
	void dfs(int i, boolean [] c) {
        visit(i);
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0) dfs(j,c);
        }
    }
	//use dept first traversal
    void dfs() {
        boolean [] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]) dfs(i, c);
        }
    }

//path from vertext u to vertext v
    int u, v;
    boolean found = false;
    int [] t;
    
    void dfspath(int i, boolean [] c) {       
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0) {
                t[j] = i;
                if(j == v) {
                    found = true;return;
                }
                dfspath(j,c);
            }
        }
    }
    void path() {
        boolean [] c = new boolean[n];
        t = new int[n];
        dfspath(u, c);
        if(found) {
            System.out.println("A path from " + vertex[u] + " to " + vertex[v]);
            int [] h = new int[n];
            int m = 0;
            h[m] = v;
            while(u != v) {
                v = t[v];
                h[++m] = v;
            }
            for (int i = m; i >= 0; i--) {
                visit(h[i]);
            }
        }else {
            System.out.println("A path from " + vertex[u] + " to " + vertex[v] + " not found");
        }
    }
	
//conectivity
	int [] tp;
    int con = 0;
    void dfscon(int i, boolean [] c) {       
        tp[i] = con;
        c[i] = true;
        for (int j = 0; j < n; j++) {
            if(!c[j] && a[i][j] > 0) {
                dfscon(j,c);
            }
        }
    }
    void connectivity() {
        con = 0;
        tp = new int[n];
        boolean [] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!c[i]) {
                con++;
                dfscon(i, c);
            }
        }
        //output connectivity vertexs
        for (int i = 1; i <= con; i++) {
            System.out.println("Connectivity " + i);
            for (int j = 0; j < n; j++) {
                if(tp[j] == i) visit(j);
            }
            System.out.println("");
        }
    }
	
//calculate degredd
   void caculateDegree(){
      for(int i = 0; i < n; i++){
          int d = 0;
          for(int j = 0; j < n; j++){
              d += a[i][j];
          }
          deg[i] = d; // deg was given
      }
	}
	
//Dijkstra algorithm
	void Dijkstra(int u, int v) {
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
            int k = -1, min = INF;
            for (int i = 0; i < n; i++) {
                if(!c[i] && d[i] < min) {
                    min = d[i];
                    k = i;
                }
            }
            if(min == INF) {
                System.out.println("Shortest path does not exists");
                return;
            }
            //chon dinh k la dinh ke tiep
            c[k] = true;
            curr = k;
            //tinh lai d va t
            for (int i = 0; i < n; i++) {
                if(d[i] > d[k] + a[k][i] && !c[i]) {
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        //tim duong di tu v den u
        System.out.println("Shortest path from " + vertex[u] + "to "
        + vertex[v] + " is " + d[v]);
        int []h = new int[n];               //
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
        visit(h[hn]);
        for (int i = hn - 1; i >= 0; i--) {
            // d[h[i]] // Hien thi cac dinh va trong so cua no 
            System.out.print("->("+w[k++]+")" + vertex[h[i]]);
        }
        System.out.println("");
    }
	
	char [] vertex;       // Them 1 cai mang nhu nay de khong bi trung voi v cua bai, nhan dien vertex
  
  void ijk(int u, int v, RandomAccessFile f123) throws Exception {
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
            int INF = 99; / Nho la INF = 99
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
        f123.writeBytes("The length of Shortest path from " + vertex[u] + "to "
        + vertex[v] + " is " + d[v]); //
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
// d[i] shortest path from u to i
// di tu u 0 v mat bn thi d[v] la xong
// h[3] la dinh thu A
// h[2] = B;
// h[1] = C;
// w trong so di tu dinh nay den dinh kia.
// w[0] = (A -> A)
// w[1] = 3(A ->B)
// w[2] = 8
// d[0] = 0;
// d[1] = 3;
// d[2] = 11;
// Tong so dinh tren duong di hn;
  
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
            int INF = 99;                                   // Nho la INF = 99
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
        f123.writeBytes("The length of Shortest path from " + vertex[u] + "to "
        + vertex[v] + " is " + d[v]); //
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
        // Bat dau tu day
      
        f123.writeBytes("\r\n"+(hn+1)); // Tong so dinh tren duong di
        // DO bien chay chay tu hn - 0 nen tong so dinh phai la hn +1 ( tinh ca vertext 0 )
        f123.writeBytes("\r\n"+d[h[0]]);    // Duong di ngan nhat tu A-F
        f123.writeBytes("\r\n");
        w[0] = 0;
        for(int i = 0; i <= wn; i++){
            f123.writeBytes(w[i]+" "); // Khoang cach tu i toi dinh j
        }
        f123.writeBytes("\r\n");
//        f123.writeBytes("\r\n"+vertex[h[hn]]);                               // No yeu cau string 
        for (int i = hn; i >= 0; i--) {
            // d[h[i]] // Hien thi cac dinh va trong so cua no 
            f123.writeBytes(vertex[h[i]]+" ");  // D[v] do dai ngan nhat tu u -> 
        }
        f123.writeBytes("\r\n");    // Xuong dong cua file no khac
    }
}