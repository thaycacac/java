
public class Euler {  
    int [][]a; int n;
    public Euler() {
     int [][]b = {
      //A  B  C  D   E
      {0, 1, 1, 0, 0},//A
      {1, 0, 1, 0, 0},//B
      {1, 1, 0, 1, 1},//C
      {0, 0, 1, 0, 1},//D
      {0, 0, 1, 1, 0}//E
     };
     a = b; n = a.length;
    }
    public void euler() {
     MyStack ms = new MyStack();
     ms.push(0);
     int [] e = new int[20];
     int ne = 0;
     while(!ms.isEmpty()) {
      int r = (int)ms.top();
      //neu r la dinh co lap -> ket nap r vao e, xoa r khoi ngan xep
      //nguoc lai, tim i la dinh dau tien co canh noi voi r
      //xoa canh noi r va i, ket nap i vao ngan xep
      int i = 0;
      while(i < n && a[r][i] == 0) i++;
      if(i == n) {//r la dinh co lap
       e[ne] = r;ms.pop();ne++;
      }
      else {a[r][i]--; a[i][r]--; ms.push(i);}
     }
     char [] c = "ABCDEFGHIJ".toCharArray();
      for (int i = 0; i < ne; i++) {
       System.out.print(c[e[i]] + "  ");
      }
      System.out.println("");
    }
}
