
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author THAYCACAC
 */
public class Graphic extends JFrame {

    public Graphic(String title) {
        super(title);
        //show windows if not run implicit
        this.setVisible(true);
        //set size windows
        this.setSize(400, 300);
        //location appear
        setLocation(200, 150);
        //stop program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //dispose on close: an nhung khong dong.
        //hide: an di
        JLabel lblTextHello = new JLabel();
        lblTextHello.setText("Hello SE1212. Wellcome PRF311");
        JButton btn = new JButton("OK");
        //place store pane
        Container con = this.getContentPane();
        con.add(lblTextHello);
        con.add(btn);
        
        //obligatory
        pack();
    }

    public static void main(String[] args) {
        new Graphic("Hello");

    }
}
