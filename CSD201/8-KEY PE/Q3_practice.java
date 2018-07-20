/**
 *
 * @author Thaycacac
 */
 
 ||__TRAVERSAL__//breadth-first traversal
 ||	    ||______//dept-first traversal
 ||
 ||___ALGORITHM_//dijkstra
 ||	         ||_//euler cycle
 ||
 ||___OTHER_____//path from vertext u to vertext v
 ||      ||_____//conectivity
 ||      ||_____//calculate degree

//breadth-first traversal
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

//dept-first traversal
  void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception{
	fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth(visited,i,f);
      }
   }
  void depth(int k, RandomAccessFile f) throws Exception{
	boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//dijkstra
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
    for (int l = 0; l < points.size()-1; l++)  f.writeBytes("("+d[(int)points.get(l)]+")"+v[l]+" "+"->");
    f.writeBytes("("+d[(int)points.get(points.size()-1)]+")"+v[points.size()-1]+" ");
    f.writeBytes("\n");
  }

//euler cycle
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
	
//calculate degree
   void caculateDegree(){
      for(int i = 0; i < n; i++){
          int d = 0;
          for(int j = 0; j < n; j++){
              d += a[i][j];
          }
          deg[i] = d; // deg was given
      }
	}