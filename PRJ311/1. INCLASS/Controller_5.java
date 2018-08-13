package Inclass;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author THAYCACAC
 */
public class Controller {

    FormLogin formLogin;
    SecondLogin secondLogin;

    public Controller(FormLogin formLogin, SecondLogin secondLogin) {
        this.formLogin = formLogin;
        this.secondLogin = secondLogin;
    }

    private void control() {
        formLogin.setVisible(true);
        formLogin.getBtLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                secondLogin.setVisible(true);
            }
        });
        secondLogin.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                formLogin.getTxtDisplay().setText("Username: " + secondLogin.getTfUsername().getText() + "\n"
                        + "Password: " + secondLogin.getPfPassword().getText());
                secondLogin.dispose();
            }
        });
    }

    public static void main(String[] args) {
        Controller controller = new Controller(new FormLogin(), new SecondLogin(null, true));
        controller.control();
    }
}
