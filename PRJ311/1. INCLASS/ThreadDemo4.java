
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THAYCACAC
 */
class DataShare2 {

    private int a, b;
    int flag = 1;

    public DataShare2() {
    }

    public DataShare2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}

public class ThreadDemo3 {

    public static void main(String[] args) {
        DataShare2 d = new DataShare2();
        Random rd = new Random();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (d.flag % 3 == 1) {
                            d.setA(rd.nextInt(10));
                            System.out.println("a = " + d.getA());
                            Thread.sleep(100);
                            d.flag++;
                            d.notifyAll();
                        }
                        d.wait();
                    } catch (Exception ex) {
                    }

                }
            }
        }); 
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (d.flag % 3 == 2) {
                            d.setB(rd.nextInt(10));
                            System.out.println("b = " + d.getB());
                            Thread.sleep(100);
                            d.flag++;
                            d.notifyAll();
                        }
                        d.wait();
                    } catch (Exception ex) {
                    }

                }
            }
        }); 
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (d.flag % 3 == 0) {
                            System.out.println("sum = " + d.sum());
                            Thread.sleep(500);
                            d.flag++;
                            d.notifyAll();
                        }
                        d.wait();
                    } catch (Exception ex) {
                    }
                }
            }
        }); 
        t1.start();
        t2.start();
        t3.start();
    }
}
