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