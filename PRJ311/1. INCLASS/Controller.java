package Calculate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author THAYCACAC
 */
public class Controller {

    CalculateFrame calculateFrame;
    MainFrame mainFrame;

    public Controller(CalculateFrame calculateFrame, MainFrame mainFrame) {
        this.calculateFrame = calculateFrame;
        this.mainFrame = mainFrame;
    }

    public void controller() {
        mainFrame.setVisible(true);
        mainFrame.getBtnCalculate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //validate a,b
                try {
                    int a = Integer.parseInt(mainFrame.getTfA().getText());
                    int b = Integer.parseInt(mainFrame.getTfB().getText());
                    calculateFrame.setVisible(true);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Must input a,b is integer",
                            "Error", 0);
                }
            }
        });
        calculateFrame.getBtnResult().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (calculateFrame.getRdbAdd().isSelected()) {
                    mainFrame.getLbResult().setText("" + (Integer.parseInt(mainFrame.getTfA().getText())
                            + Integer.parseInt(mainFrame.getTfB().getText())));
                    calculateFrame.dispose();
                }
                if (calculateFrame.getRdbSub().isSelected()) {
                    mainFrame.getLbResult().setText("" + (Integer.parseInt(mainFrame.getTfA().getText())
                            - Integer.parseInt(mainFrame.getTfB().getText())));
                }
                if (calculateFrame.getRdbMulti().isSelected()) {
                    mainFrame.getLbResult().setText("" + (Integer.parseInt(mainFrame.getTfA().getText())
                            * Integer.parseInt(mainFrame.getTfB().getText())));
                }
                if (calculateFrame.getRdbDiv().isSelected()) {
                    mainFrame.getLbResult().setText("" + (Integer.parseInt(mainFrame.getTfA().getText())
                            / Integer.parseInt(mainFrame.getTfB().getText())));
                }
            }
        });
    }

    public static void main(String[] args) {
        Controller controller = new Controller(new CalculateFrame(null, true), new MainFrame());
        controller.controller();
    }
}
