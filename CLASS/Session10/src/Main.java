
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static void textStream() {
        try {
            FileWriter fw = null;
            BufferedWriter bw = null;
            String fname = "Data.txt";
            fw = new FileWriter(fname, true);//default false - override
            bw = new BufferedWriter(fw);
            bw.write("the quick brown fox");
            bw.write(100);
            bw.close();
            fw.close();
            //read data fromfname
            BufferedReader br = new BufferedReader(new FileReader(fname));
            int c;
            while ((c = br.read()) != -1) {
                System.out.println((char) c);
            }
            System.out.println("");
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        textStream();
        String path = "D:\\data\\img\\1.jpg";//bad style
        path = "D:/data/img/1.jpg";//good style
        path = "build.xml";
        File f = new File(path);
        if (f.exists()) {
            System.out.println("FullPath: " + f.getAbsolutePath());
            System.out.println("length(in byte): " + f.length());
            System.out.println("file name: " + f.getName());
            System.out.println("lastModified: " + new Date(f.lastModified()));
            System.out.println("isFile" + f.isFile());
        } else {
            try {
                f.createNewFile();
                System.out.println("press enter t remove created file");
                new Scanner(System.in).nextLine();
                f.delete();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
