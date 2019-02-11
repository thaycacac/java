package dal;

import dataobj.Student;
import db.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class StudentDAO {

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            java.sql.Connection con = null;
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                System.out.println("connected");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from Student");
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("ID"));
                    student.setName(rs.getString("Name"));
                    student.setDob(rs.getDate("BOD"));
                    student.setImage(rs.getString("image"));
                    listStudent.add(student);
                }
                rs.close();
                stmt.close();
                con.close();
                for (Student student : listStudent) {
                    System.out.println("Student: " + student.getName() + " "
                            + student.getId() + " " + student.getImage() + " " + student.getDob());
                }
            } else {
                System.out.println("fail connected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listStudent;
    }
    
    public void addStudent(Student student){
        try {
            java.sql.Connection con = null;
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                System.out.println("connected");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO STUDENT () VALUE (?,?) ;");
                stmt.setString(1, student.getName());
                stmt.setString(2, student.getImage());
                stmt.executeUpdate();
                stmt.close();
                con.close();
                
            } else {
                System.out.println("fail connected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
