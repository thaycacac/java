
/**
 *
 * @author THAYCACAC
 */
class tempThread2 implements Runnable {

    public static String change(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    @Override
    public void run() {
        String s = "Hello SE1212";
        while (true) {
            System.out.println(s);
            s = change(s);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

//public class ThreadDemo2 {
//
//    public static void main(String[] args) {
//        Thread t = new Thread(new tempThread2());
//        t.start();
//    }
//}


public class ThreadDemo2 extends Thread {

    @Override
    public void run() {
        String s = "Hello SE1212";
        while (true) {
            System.out.println(s);
            s = tempThread2.change(s);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new ThreadDemo2();
        t.start();
    }
}



