package J2SP0111;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Thaycacac
 */
public class Controller {
    
    static int number;
    static String expression = "";
    
    public static void controller(MainFrame main) {
        inputNumber(main);
    }
    
    public static int getResult(String expression, int num, int number) {
        switch (expression) {
            case "plus":
                number += num;
                break;
            case "sub":
                number -= num;
                break;
            case "mul":
                number *= num;
                break;
            case "div":
                number /= num;
                break;
            case "mod":
                number %= num;
                break;
        }
        return number;
    }
    
    public static void inputNumber(MainFrame main) {
        main.getBtn0().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 0;
                } else {
                    number = getResult(expression, 0, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 1;
                } else {
                    number = getResult(expression, 1, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 2;
                } else {
                    number = getResult(expression, 2, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 3;
                } else {
                    number = getResult(expression, 3, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 4;
                } else {
                    number = getResult(expression, 4, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 5;
                } else {
                    number = getResult(expression, 5, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn6().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 6;
                } else {
                    number = getResult(expression, 6, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn7().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 7;
                } else {
                    number = getResult(expression, 7, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn8().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 8;
                } else {
                    number = getResult(expression, 8, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtn9().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (expression.isEmpty()) {
                    number = 9;
                } else {
                    number = getResult(expression, 9, number);
                }
                expression = "";
                main.getTfResult().setText(Integer.toString(number));
            }
        });
        main.getBtnEqua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                number = 0;
//                main.getTfResult().setText(number);
            }
        });
        main.getBtnPlus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                expression = "plus";
            }
        });
        main.getBtnSub().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                expression = "sub";
            }
        });
        main.getBtndiv().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                expression = "div";
            }
        });
        main.getBtnMul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                expression = "mul";
            }
        });
        main.getBtnMod().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                expression = "mod";
            }
        });
        main.getBtnCe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                number = 0;
                expression = "";
                main.getTfResult().setText("0");
            }
        });
    }
    
    public static void main(String[] args) {
        MainFrame main = new MainFrame();
        main.setVisible(true);
        controller(main);
    }
}
