package session9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        //Collections
        List a = new Vector();
        a.add(true);//true
        a.add("ciao");//true, ciao
        a.add(Integer.valueOf("165"));//true, ciao, 165
        a.remove(0);//ciao, 165
        int i = a.indexOf("ciao");
        a.remove(i);//165
        a.add(a.get(0));//165, 165
        a.add(a.contains(166));//165, 165, false
        Iterator it = a.iterator();//cho con chay tren day a
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //Arraylist (non-synchnronized speed) 
        //Vector (synchnronized safe tgread)
    }

}
