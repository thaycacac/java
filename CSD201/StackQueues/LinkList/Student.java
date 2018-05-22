package LinkList;



/**
 *
 * @author thaycacac
 */
public class Student {

    private int ID;
    private String Name;

    public Student(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return ID + "\t" + Name;
    }

}
