
import java.util.Arrays;
import java.util.Scanner;

public class StringMain {

    public static void main(String[] args) {
       String s = "the";
       StringBuffer sb = new StringBuffer(s); //the
       sb.append(" quick"); //the quick
       sb.append(" fox "); //the quick fox
       sb.append(2018);//the quick fox 2018
       int i = sb.indexOf("fox");
       sb.insert(i, "fire"); //the quick firefox 2018;
       sb.setCharAt(0, 'T');//The quick firefox 2018
       s = sb.toString();
       System.out.println(s);
       sb.deleteCharAt(0);// xóa phần tử ở vị trí 0
       System.out.println(sb);

        String s1, s2;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        s1 = in.nextLine();
        System.out.print("Enter another string: ");
        s2 = in.nextLine();
        int count = 0;


       while (s1.indexOf(s2) != -1) {
           int i = s1.indexOf(s2);
           if (i != -1) {
               count++;
               StringBuffer sb = new StringBuffer(s1);
               sb.delete(i, s2.length() + 1);
               s1 = sb.toString();
           }
       }
       System.out.println(count);

       

        int i = -1;
        while ((i = s1.indexOf(s2, i + 1)) != -1) {
            count++;
        }
        System.out.println(count);
        //if(s1.contains(s2))

        //ws6.2.5
        String[] st = s1.split("\\s+");
        Arrays.sort(st);
        System.out.println(st);

        //ws6.2.6
        i = s1.indexOf(s2);
        StringBuffer sb = new StringBuffer(s1).delete(i, i + s2.length());
        s1 = s1.toString();
        System.out.println(s1);
    }
}
