package InClass;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THAYCACAC
 */
public class Controller {

    StudentInfo studentInfo;
    DefaultTableModel defaultTableModel = new DefaultTableModel();

    public Controller(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public void control() {
        studentInfo.setVisible(true);
        studentInfo.getBtnLoad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                readFile();
            }

            private void readFile() {
                try {
                    RandomAccessFile raf = new RandomAccessFile("data.txt", "r");
                    String s = null;
                    Object[] firstRow = {"ID","Name","Gender","Age","Salary"};
                    defaultTableModel.setColumnIdentifiers(firstRow);
                    defaultTableModel.setRowCount(0);
                    while((s=raf.readLine())!=null){
                        StringTokenizer token = new StringTokenizer(s,"|");
                        Vector vector = new Vector();
                        while(token.hasMoreElements()){           
                            vector.add(token.nextElement());
                        }
                        defaultTableModel.addRow(vector);
                    }
                    raf.close();
                    studentInfo.getTbStudentInfo().setModel(defaultTableModel);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) { 
        StudentInfo studentInfo = new StudentInfo();
        Controller controller = new Controller(studentInfo);
        controller.control();
        
    }
}
