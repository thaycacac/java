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