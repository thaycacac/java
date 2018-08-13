
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THAYCACAC
 */
public class ThreadDemo {

    public static synchronized void print(String threadName) {
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("in thread with name "
                        + threadName + " " + i);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                print(Thread.currentThread().getName());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                print(Thread.currentThread().getName());
            }
        });
        t1.start();
//        try {
//            t1.join();
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        t2.start();

        /**
         * t1.start(); t2.start(); try { Thread.sleep(1000); t1.suspend();
         * Thread.sleep(1000); t2.suspend(); t1.resume(); Thread.sleep(1000);
         * t2.resume(); } catch (Exception e) { }
         */
    }
}
