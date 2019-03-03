package J2SP0117;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THAYCACAC
 */
public class Controller {

    Main main;
    Edit edit;
    Connection con = null;
    DAO dao = new DAO(new DBContext(), con);
    DefaultTableModel dftb = new DefaultTableModel();
    HashSet hs = new HashSet();

    public Controller() {
    }

    public Controller(Main main, Edit edit) {
        this.main = main;
        this.edit = edit;
    }

    private void control() {
        main.setVisible(true);
        displayData();
        edit();
    }

    //display info stock user want to edit to dialog edit
    private void edit() {
        //display info stock user want to edit to dialog edit
        main.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int n = main.getTbStock().getSelectedRow();
                //check user choose stock to edit
                if (n == -1) {
                    JOptionPane.showMessageDialog(null, "Must be choose stock.");
                    return;
                }
                edit.setVisible(true);
                //display info to form edit
                edit.getTfStockName().setText((String) main.getTbStock().getValueAt(n, 1));
                edit.getTfAddress().setText((String) main.getTbStock().getValueAt(n, 2));
                edit.getTfDate().setText((String) main.getTbStock().getValueAt(n, 3));
                edit.getTfNote().setText((String) main.getTbStock().getValueAt(n, 4));
            }
        });

        //user edit infor and update
        edit.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String sql = "UPDATE Stocks\n"
                            + "SET StockName = '" + edit.getTfStockName().getText() + "', \n"
                            + "Address = '" + edit.getTfAddress().getText() + "', \n"
                            + "DateAvailable='" + edit.getTfDate().getText() + "', \n"
                            + "Note='" + edit.getTfNote().getText() + "'\n"
                            + "WHERE StockID = '" + main.getTbStock().getValueAt(main.getTbStock().getSelectedRow(), 0) + "'";

                    ResultSet rs = dao.getData(sql);
                    displayData();
                    edit.dispose();
                } catch (Exception e) {
                }
            }
        });
    }

    //display table stock to table
    private void displayData() {
        try {
            String sql = "SELECT * FROM dbo.Stocks";
            ResultSet rs = dao.getData(sql);
            Object[] title = {"StockID", "StockName", "Address", "DateAvailable", "Note"};
            dftb.setColumnIdentifiers(title);
            dftb.setRowCount(0);
            hs.clear();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString(1));
                hs.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                dftb.addRow(vector);
            }
            main.getTbStock().setModel(dftb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Controller controller = new Controller(main, new Edit(main, false));
        controller.control();
    }
}
