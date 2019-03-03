package session9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MySet {

    public static void main(String[] args) {
       Set<String> strings = new HashSet<>();
       strings.add("hello");
       strings.add("lambade");
       strings.add("alibaba");
       strings.add("alibaba");
       strings.add("ciao");
       Iterator<String> it = strings.iterator();
       while (it.hasNext()) {
           System.out.println(it.next());
       }
       
        Set<Square> squares = new TreeSet();
        squares.add(new Square(4, true));
        squares.add(new Square(5, true));
        squares.add(new Square(3, true));
        squares.add(new Square(4, false));//k biet lap hay k
        Iterator<Square> it = squares.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
