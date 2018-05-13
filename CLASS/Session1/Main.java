
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //local variable
        float f$ = 1.34f;//f để phân biệt với double
        final double d = 3.14;
        char c = 'A';
        c = '\u00CA'; //E^
        System.out.println("c=" + c);

        int i, k;
        i = 13;
        k = i >> 2;
        System.out.println("i = " + i);//1101
        System.out.println("i>>2 = " + k);//11
        System.out.println("i<<2 = " + (i << 2));//110100

        Object[] a = new Object[5];
        int[] b = {1, 2, 3, 4, 5};
        a[0] = 10;//boxing
        a[1] = true;//boxing
        a[2] = 3.14;//boxing
        a[3] = "The fox";//casting-implicit
        a[4] = 20.5;//boxing
        //output integer values only
        for (Object v : a) {
            if (v instanceof Integer) {//instanceof không nhận primitive chỉ nhận references nhưng có một kdl bên references
                k = (int) v;//unboxing
                System.out.println(k);
            }
        }

        Scanner in = new Scanner(System.in);//System.in/out/err - nhập chuẩn, xuất chuẩn
        in.useDelimiter("\n");//xác định ký tự lấy cuối cùng
        //in.useLocale(Locale.US)
        System.out.println("Enter a number: ");
        //k = in.nextInt();
        k = Integer.valueOf(in.nextInt())
        System.out.println("k = " + k);
        System.out.println("Enter a sting: ");
        //String s = in.nextLine();
        String s = in.next();
        System.out.println("s = " + s);
        /*
        không bị trôi có thể dùng
        - String s = in.next(); nhưng không lấy được dấu cách
        - int k = Integer.valueOf(in.nextInt()); chuyển đổi số thành chữ
         */
    }
}
