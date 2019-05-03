
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyStudent {

    public static void main(String[] args) {
        try {
            Student s1 = new Student("Mo", 3);
            Student s2 = new Student("Choi", 2);
            FileOutputStream fos = new FileOutputStream("sv.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);//deserialization
            oos.writeObject(s1);
            oos.writeDouble(Math.PI);
            oos.close();
            fos.close();
            //reading
            FileInputStream fis = new FileInputStream("sv.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Student)ois.readObject();//serialization
            System.out.println(s1);
            System.out.println(ois.readObject());
            System.out.println(ois.readDouble());
            ois.close();;
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
           // System.out.println(e);x`
        }
    }
}
