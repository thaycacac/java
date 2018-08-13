
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class ThreadDemo {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int[] a;

        int sizeOfArray, numberOfThreaad;
        System.out.print("Input size of array: ");
        sizeOfArray = Integer.parseInt(in.nextLine());
        a = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            a[i] = random.nextInt(10);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.print("Input number of thread: ");
        numberOfThreaad = Integer.parseInt(in.nextLine());
        Thread[] threads = new Thread[numberOfThreaad];
        for (int i = 0; i < numberOfThreaad; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int startThread = Integer.parseInt(Thread.currentThread().getName());
                    for (int j = startThread; j < sizeOfArray; j += numberOfThreaad) {
                        sum += a[j];
                    }
                }
            });
            threads[i].setName(i + "");
        }
        for (int i = 0; i < numberOfThreaad; i++) {
            threads[i].start();
            if (threads[i].isAlive()) {
                try {
                    threads[i].join();
                } catch (InterruptedException ex) {
                }
            }
        }
        System.out.println("Sum = " + sum);
        
        //check sum corrects
        int sum2 = 0;
        for (int i = 0; i < sizeOfArray; i++) {
            sum2 += a[i];
        }
        System.out.println("Sum Check = " + sum2);
    }
}
//HW: chia lien tuc
