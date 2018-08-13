package HomeWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author THAYCACAC
 */
public class Controller {

    MainFrame mainFrame;
    CustomText customText;

    public Controller(MainFrame mainFrame, CustomText customText) {
        this.mainFrame = mainFrame;
        this.customText = customText;
    }

    private void textLeftToRight() {
        String origin = mainFrame.getJlbHelloWorld().getText();
        String afterEdit = origin.substring(1) + origin.charAt(0);
        mainFrame.getJlbHelloWorld().setText(afterEdit);
    }

    private void textRightToLeft() {
        String origin = mainFrame.getJlbHelloWorld().getText();
        String afterEdit = origin.charAt(origin.length() - 1)
                + origin.substring(0, origin.length() - 1);
        mainFrame.getJlbHelloWorld().setText(afterEdit);
    }

    private void changeColor() {
        if (mainFrame.getJlbHelloWorld().getForeground() == Color.YELLOW) {
            mainFrame.getJlbHelloWorld().setForeground(Color.GREEN);
        } else if (mainFrame.getJlbHelloWorld().getForeground() == Color.GREEN) {
            mainFrame.getJlbHelloWorld().setForeground(Color.BLUE);
        } else if (mainFrame.getJlbHelloWorld().getForeground() == Color.BLUE) {
            mainFrame.getJlbHelloWorld().setForeground(Color.PINK);
        } else {
            mainFrame.getJlbHelloWorld().setForeground(Color.YELLOW);
        }
    }

    String[] fontName = {"Times new roman", "Tahoma","Lato"};
    int fName = 0;
    private void changeFontName() {
//        System.out.println(fontName[fName++%3]);
//        int fontSize = mainFrame.getJlbHelloWorld().getFont().getStyle();
//        int fontStyle = mainFrame.getJlbHelloWorld().getFont().getSize();
//        Font newFont = new Font(fontName[fName++%3], fontStyle, fontSize);
//        mainFrame.getJlbHelloWorld().setFont(newFont);
    }
    int[] fontStyle = {0, 1, 2, 3};
    int fStyle = 0;

    private void changeFontStyle() {
//        int fontSize = mainFrame.getJlbHelloWorld().getFont().getStyle();
//        String fontName = mainFrame.getJlbHelloWorld().getFont().getFontName();
//        Font newFont = new Font(fontName, fontStyle[fStyle++ % 4], fontSize);
//        mainFrame.getJlbHelloWorld().setFont(newFont);
    }

    int[] fontSize = {8, 10, 12, 14, 16, 20, 25, 36};
    int fSize = 0;

    private void changeFontSize() {
        String fontName = mainFrame.getJlbHelloWorld().getFont().getFontName();
        int fontStyle = mainFrame.getJlbHelloWorld().getFont().getSize();
        Font newFont = new Font(fontName, fontStyle, fontSize[fSize++ % 8]);
        mainFrame.getJlbHelloWorld().setFont(newFont);
    }

    private void control() {
        mainFrame.setVisible(true);
        Thread thread = new Thread();
        mainFrame.getBtnStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                customText.setVisible(true);
            }
        });

        customText.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                customText.setVisible(false);
            }
        });

        while (true) {
            if (customText.getRdbLeftToRight().isSelected()) {
                textLeftToRight();
            }
            if (customText.getRdbRightToLeft().isSelected()) {
                textRightToLeft();
            }
            if (customText.getChbFontName().isSelected()) {
                changeFontName();
            }
            if (customText.getChbFontSize().isSelected()) {
                changeFontSize();
            }
            if (customText.getChbFontStyle().isSelected()) {
                changeFontStyle();
            }
            if (customText.getChbChangeColor().isSelected()) {
                changeColor();
            }
            try {
                thread.sleep(customText.getJsdSpeed().getValue());
            } catch (Exception e) {
            }
//            thread.start();
        }

    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Controller control = new Controller(mainFrame, new CustomText(mainFrame, true));
        control.control();
    }
}
