package Optimize;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THAYCACAC
 */
class DAO {//data access object

    DBContext db;
    Connection con;

    public DAO(DBContext db, Connection con) {
        this.db = db;
        try {
            con = db.getConnection();
        } catch (Exception e) {
            System.err.println("Error connection.");
        }
        this.con = con;
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.err.println("Error connection.");
        }
        return rs;
    }

    public PreparedStatement getPS(String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (Exception e) {
            return null;
        }
    }
}

public class Controller {

    DAO dao;
    StudentTable view;
    DefaultTableModel dftb = new DefaultTableModel();
    HashSet hs = new HashSet();
    HashMap<String, String> hm = new HashMap();

    public Controller(DAO dao, StudentTable view) {
        this.dao = dao;
        this.view = view;
    }

    public void control() {
        view.setVisible(true);
        view.getTbStudentInfomation().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                view.getTbStudentInfomation().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent lse) {
                        int n = view.getTbStudentInfomation().getSelectedRow();
                        //first line is -1
                        if (n >= 0) {
                            view.getTxtStudentId().setText(view.getTbStudentInfomation().getValueAt(n, 0).toString());
                            view.getTxtStudentName().setText(view.getTbStudentInfomation().getValueAt(n, 1).toString());
                            view.getSldAge().setValue((int) view.getTbStudentInfomation().getValueAt(n, 4));
                            view.getChkGender().setSelected((boolean) view.getTbStudentInfomation().getValueAt(n, 3));
                            view.getCbDepart().setSelectedItem(view.getTbStudentInfomation().getValueAt(n, 2).toString());
                        }
                    }
                });
            }
        });

        view.getBtnLoad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                load();
            }
        });

        view.getBtnUpdate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String sql = "UPDATE dbo.StudentInfomation SET StudentName = ?,"
                            + " DepartId = ?, Gender = ?, Age = ? WHERE StudentId = ?";
                    PreparedStatement ps = dao.getPS(sql);
                    if (hs.contains(view.getTxtStudentId().getText())) {
                        ps.setString(1, view.getTxtStudentName().getText());
                        ps.setString(2, hm.get(view.getCbDepart().getSelectedItem()));
                        ps.setBoolean(3, view.getChkGender().isSelected());
                        ps.setInt(4, view.getSldAge().getValue());
                        ps.setString(5, view.getTxtStudentId().getText());
                        ps.executeUpdate();
                        load();
                    } else {
                        //do nothing
                    }
                } catch (Exception e) {
                }
            }
        });

    }

    //load infomation of student to table
    private void load() {
        try {
            String sql = "SELECT s.StudentId, s.StudentName, d.DepartName,s.Gender, s.Age\n"
                    + "FROM dbo.StudentInfomation s, dbo.DepartInfomation d\n"
                    + "WHERE s.DepartId=d.DepartId";
            ResultSet rs = dao.getData(sql);
            Object[] title = {"ID", "Name", "Depart", "Gender", "Age"};
            dftb.setColumnIdentifiers(title);
            dftb.setRowCount(0);
            hs.clear();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                hs.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getBoolean(4));
                vector.add(rs.getInt(5));
                dftb.addRow(vector);
                view.getTbStudentInfomation().setModel(dftb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con = null;
        Controller controler = new Controller(new DAO(new DBContext(), con), new StudentTable());
        controler.control();
    }

}
