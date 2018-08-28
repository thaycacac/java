package dal;

import dataobj.Job;
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
public class JobDAO {

    public void insertJob(String name, String code, int exp, String des) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Job (JobTitle, CompanyCode,"
                    + "YearExp, Description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, code);
            stmt.setInt(3, exp);
            stmt.setString(4, des);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Job> selectJob() {
        ArrayList<Job> listJob = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Job";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);
                int exp = rs.getInt(4);
                String des = rs.getString(5);
                Job job = new Job(id, name, code, exp, des);
                listJob.add(job);
            }
            rs.close();
            stmt.close();
            con.close();
            return listJob;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateJob(int id, String name, String code, int exp, String des) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "UPDATE Job SET JobTitle = ?, CompanyCode = ?,"
                    + "YearExp = ?, Description = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, code);
            stmt.setInt(3, exp);
            stmt.setString(4, des);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteJob(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Job WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return;
    }

    public Job selectJobById(int id) {
        ArrayList<Job> listJob = new ArrayList<>();
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Job WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idEdit = rs.getInt(1);
                String name = rs.getString(2);
                String code = rs.getString(3);
                int exp = rs.getInt(4);
                String des = rs.getString(5);
                Job job = new Job(idEdit, name, code, exp, des);
                return job;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
