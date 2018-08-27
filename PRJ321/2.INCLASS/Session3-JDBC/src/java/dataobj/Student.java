package dataobj;

import java.sql.Date;

/**
 *
 * @author Thaycacac
 */
public class Student {

    private int id;
    private String name;
    private Date dob;
    private String image;

    public Student() {
    }

    public Student(int id, String name, Date dob, String image) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.image = image;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
