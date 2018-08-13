
/**
 *
 * @author THAYCACAC
 */
class tempThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("In Thread t1 " + i);
        }
    }
}

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("In Thread t2 " + i);
//            Thread.yield();//concessions
            try {
                sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//way1
        Thread t0 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("In Thread " + i);
                }
            }
        };
        t0.start();//one times

//way2
        Thread t = new Thread(new tempThread());//obj anonymous
        t.start();

//way3
        ThreadDemo t2 = new ThreadDemo();
        t2.start();

//way4
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("In Thread " + i);
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println("In main " + i);
        }
        //default Priority = 5
        t.setPriority(MIN_PRIORITY);
        t2.setPriority(MAX_PRIORITY);

        System.out.println("Do uu tien: cuar t: " + t.getPriority());
        System.out.println("Do uu tien cua t2: " + t2.getPriority());

        //set name thread
        //default: thread 0/-1/...
        t.setName("hoa");
        t2.setName("hong");
        System.out.println("Ten cua thread t: " + t.getName());
        System.out.println("Ten cua thread t2:" + t2.getName());
    }
}
