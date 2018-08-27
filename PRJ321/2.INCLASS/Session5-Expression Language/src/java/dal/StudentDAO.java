package dal;

import dataobj.Student;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class StudentDAO {

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from StudentFap");
            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getInt(1));
                student.setGroup(rs.getString(2));
                student.setCode(rs.getString(3));
                student.setName(rs.getString(4));
                student.setImage(rs.getString(5));
                student.setStatus(rs.getString(6));
                student.setComment(rs.getString(7));
                student.setTaker(rs.getString(8));
                student.setTime(rs.getDate(9));
                listStudent.add(student);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listStudent;
    }

    public void addStudent(Student student) {
        try {
            Connection con = null;
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                PreparedStatement stmt = con.prepareStatement("insert into studentFap (No, [Group], Code, Name, Image, Status, Comment, Taker, Time)\n"
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, student.getNo());
                stmt.setString(2, student.getGroup());
                stmt.setString(3, student.getCode());
                stmt.setString(4, student.getName());
                stmt.setString(5, student.getImage());
                stmt.setString(6, student.getStatus());
                stmt.setString(7, student.getComment());
                stmt.setString(8, student.getTaker());
                stmt.setDate(9, student.getTime());

                stmt.executeUpdate();
                stmt.close();
                con.close();
            } else {
                System.out.println("fail connect");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteStudent(Student student) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            if (con != null) {
                PreparedStatement stmt = con.prepareStatement("delete studentFap where Code = ?");
                stmt.setString(1, student.getCode());

                stmt.executeUpdate();
                stmt.close();
                con.close();
            } else {
                System.out.println("fail connect");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement("update studentFap set No = ?, [Group] = ?, Name = ?, Image = ?, Status = ?, Comment = ?, Taker = ?, Time = ? where Code = ?");
            stmt.setInt(1, student.getNo());
            stmt.setString(2, student.getGroup());
            stmt.setString(3, student.getCode());
            stmt.setString(4, student.getName());
            stmt.setString(5, student.getImage());
            stmt.setString(6, student.getStatus());
            stmt.setString(7, student.getComment());
            stmt.setString(8, student.getTaker());
            stmt.setDate(9, student.getTime());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList listStudentByTaker(ArrayList<Student> listStudent, String username) {
        ArrayList<Student> listStudentByTaker = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getTaker().equals(username)) {
                listStudentByTaker.add(student);
            }
        }
        return listStudentByTaker;
    }
}
