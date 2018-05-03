
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class myDictionary {

    Map<String, String> m = new HashMap<>();

    //load mydictionary.txt to m
    void create() {
        try {
            RandomAccessFile raf = new RandomAccessFile("mydictionary.txt", "rw");
            raf.writeBytes("house=Ngôi nhà");
            raf.writeBytes("\n\rcar=Xe ô tô");
            raf.seek(0);
            String s;
            while ((s = raf.readLine()) != null) {
                if (!s.isEmpty()) {
                    String[] st = s.split("=");
                    m.put(st[0], st[1]);
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void output() {
        Iterator<String> keys = m.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + "=" + m.get(key));

        }
    }

    public static void main(String[] args) {
        myDictionary md = new myDictionary();
        md.create();
        md.output();
    }
}
