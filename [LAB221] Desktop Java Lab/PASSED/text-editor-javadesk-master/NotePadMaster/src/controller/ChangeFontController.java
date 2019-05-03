package controller;

import form.ChangeFontForm;
import form.MainForm;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author thaycacac<thaycacac@gmail.com>
 */
public class ChangeFontController {

    // init font form
    public void setupChangeFontForm(ChangeFontForm changeFontForm) {
        changeFontForm.getJpnReview().setPreferredSize(new Dimension(150, 50));
        changeFontForm.setTitle("Font");
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        changeFontForm.getListFont().setListData(fonts);
        String styles[] = {"Regular", "Bold", "Italic", "Bold Italic"};
        changeFontForm.getListStyle().setListData(styles);
        String sizes[] = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "36", "40", "72"};
        changeFontForm.getListSize().setListData(sizes);
    }

    // set up change font
    public void setupChangeFont(MainForm mainForm, ChangeFontForm changeFontForm) {
        String fontCurrent = mainForm.getTxtArea().getFont().getFamily();
        int styleCurrent = mainForm.getTxtArea().getFont().getStyle();
        int sizeCurrent = mainForm.getTxtArea().getFont().getSize();
        changeFontForm.getListFont().setSelectedValue(fontCurrent, true);
        changeFontForm.getListStyle().setSelectedIndex(styleCurrent);
        changeFontForm.getListSize().setSelectedValue(Integer.toString(sizeCurrent), true);
        changeFontForm.getTxtSize().setText(Integer.toString(sizeCurrent));
        changeFontForm.getTextFont().setText(fontCurrent);
        changeFontForm.getTextStyle().setText(changeFontForm.getListStyle().getSelectedValue());
    }

    // when user change font
    public void changeFont(MainForm mainForm, ChangeFontForm changeFontForm) {
        changeFontForm.getListFont().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String fontChoose = changeFontForm.getListFont().getSelectedValue();
                int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                int sizeCurrent = changeFontForm.getTextReview().getFont().getSize();
                changeFontForm.getTextFont().setText(fontChoose);
                changeFontForm.getTextReview().setFont(new Font(fontChoose, styleCurrent, sizeCurrent));
            }
        });
    }

    // when user change style
    public void changeStyle(MainForm mainForm, ChangeFontForm changeFontForm) {
        changeFontForm.getListStyle().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int styleChoose = changeFontForm.getListStyle().getSelectedIndex();
                String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                int sizeCurrent = changeFontForm.getTextReview().getFont().getSize();
                switch (styleChoose) {
                    case 0:
                        changeFontForm.getTextStyle().setText("Regular");
                        break;
                    case 1:
                        changeFontForm.getTextStyle().setText("Bold");
                        break;
                    case 2:
                        changeFontForm.getTextStyle().setText("Italic");
                        break;
                    case 3:
                        changeFontForm.getTextStyle().setText("Bold Italic");
                        break;
                }
                changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleChoose, sizeCurrent));
            }
        });
    }

    // when user change size
    public void changeSize(MainForm mainForm, ChangeFontForm changeFontForm) {
        changeFontForm.getListSize().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String sizeChoose = changeFontForm.getListSize().getSelectedValue();
                String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                changeFontForm.getTextSize().setText(sizeChoose);
                changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleCurrent, Integer.parseInt(sizeChoose)));
            }
        });
        changeFontForm.getTextSize().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String sizeChoose = changeFontForm.getTextSize().getText();
                if (sizeChoose != "") {
                    String fontCurrent = changeFontForm.getTextReview().getFont().getFontName();
                    int styleCurrent = changeFontForm.getTextReview().getFont().getStyle();
                    changeFontForm.getTextReview().setFont(new Font(fontCurrent, styleCurrent, Integer.parseInt(sizeChoose)));
                }
            }
        });
    }

    // click cancel or oke
    public void clickButtonChangeFontForm(MainForm mainForm, ChangeFontForm changeFontForm) {
        changeFontForm.getBtnOk().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontCurrent = changeFontForm.getListFont().getSelectedValue();
                int styleCurrent = changeFontForm.getListStyle().getSelectedIndex();
                int sizeCurrent = Integer.parseInt(changeFontForm.getTextSize().getText());
                mainForm.getTxtArea().setFont(new Font(fontCurrent, styleCurrent, sizeCurrent));
                changeFontForm.setVisible(false);
            }
        });
        changeFontForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFontForm.setVisible(false);
            }
        });
    }
}
