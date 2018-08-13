
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THAYCACAC
 */
class DataShare {

    int[] a;
    int n;

    public DataShare() {
    }

    public DataShare(int n) {
        this.n = n;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (new Random()).nextInt(10);
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}

public class ThreadDemo2 {

    public static void main(String[] args) {
        DataShare d = new DataShare(10);
        d.print();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (d) {
                    for (int i = 0; i < d.n; i++) {
                        d.a[i] *= 2;
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (d) {
                    for (int i = 0; i < d.n; i++) {
                        d.a[i] += 1;
                    }
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        d.print();
    }
}
