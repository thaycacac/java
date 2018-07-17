
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Hashtable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

/**
 *
 * @author THAYCACAC
 */
public class PRJ311 extends javax.swing.JFrame {

    Thread thread;
    boolean checkRun = false;
    String speed;

    /*
    ***Register
     */
    public PRJ311() {
        initComponents();
        lbText.setText(lbText.getText().trim() + " ");
        initThread();
        thread.start();
        setFontName();
        controlLabel();
        initLabel();
    }

    //program run thread
    private void initThread() {
        thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (rdbMoveLeft.isSelected()
                            && checkRun == true
                            && cbTextRun.isSelected()) {
//                        moveTextRightToLeft();

                        hiddenString = shiftText(hiddenString);
//                        putTextToLabel(hiddenString);
//                        putTextThreeColorType1(hiddenString);
                        putTextThreeColorType2(hiddenString);

//                        hiddenString = shiftTextTwoChar(hiddenString);
//                        putTextTwoCharType1(hiddenString);
//                        putTextTwoCharType2(hiddenString);

                        if (cbChangeColor.isSelected()) {
                            changeColor();
                        }
                        if (cbChangeFont.isSelected()) {
                            changeFont();
                        }
                    } else if (rdbMoveRight.isSelected()
                            && checkRun == true
                            && cbTextRun.isSelected()) {
//                        moveTextRightToLeft();

                        hiddenString = shiftText(hiddenString);
//                        putTextToLabel(hiddenString);
//                        putTextThreeColorType1(hiddenString);
                        putTextThreeColorType2(hiddenString);

//                        hiddenString = shiftTextTwoChar(hiddenString);
//                        putTextTwoCharType1(hiddenString);
//                        putTextTwoCharType2(hiddenString);
                        if (cbChangeColor.isSelected()) {
                            changeColor();
                        }
                        if (cbChangeFont.isSelected()) {
                            changeFont();
                        }
                    }
                    try {
                        sleep(Integer.parseInt(tfInputSpeed.getText()));
                    } catch (Exception e) {
                    }
                }
            }
        };
    }

    //allow user move text right to left
    private void moveTextRightToLeft() {
        String s = lbText.getText();
        s = s.substring(1) + s.charAt(0);
        lbText.setText(s);
    }

    //allow user move text right to left
    private void moveTextLeftToRight() {
        String s = lbText.getText();
        s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        lbText.setText(s);
    }

    //user check change color then color of text will change -> red -> yello -> 
    //green -> blue
    private void changeColor() {
        Color color = lbText.getForeground();
        if (color == Color.BLACK) {
            lbText.setForeground(Color.RED);
        } else if (color == Color.RED) {
            lbText.setForeground(Color.YELLOW);
        } else if (color == Color.YELLOW) {
            lbText.setForeground(Color.BLUE);
        } else if (color == Color.BLUE) {
            lbText.setForeground(Color.GREEN);
        } else {
            lbText.setForeground(Color.BLACK);
        }
    }

    int fontStyle = 0;
    int fontSize = 15;
    String[] fontName = {"Times", "Italic", "Verdana"};
    int count = 0;

    //allow user change font(font size, font style, name)
    private void changeFont() {
        lbText.setFont(new Font(fontName[count++ % fontName.length],
                fontStyle++ % 4,
                fontSize++ % 36));
    }

    //change value below text slider bar 
    private void controlLabel() {
        int i;
        Hashtable<Integer, JLabel> mysldBarSpeed = new Hashtable<Integer, JLabel>();
        for (i = sldSpeed.getMinimum(); i < sldSpeed.getMaximum();
                i += sldSpeed.getMajorTickSpacing()) {
            mysldBarSpeed.put(i, new JLabel(i / 100 + ""));
        }
        mysldBarSpeed.put(i, new JLabel(sldSpeed.getMaximum() / 100 + ""));
        sldSpeed.setLabelTable(mysldBarSpeed);
    }

    //change color text green and blue sequence
    private void initLabel() {
        String s = lbText.getText();
        String result = "<html>";
        lbText.setText(result);

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                result += "<span style='color: green'>" + s.charAt(i) + "<span>";
            } else {
                result += "<span style='color: blue'>" + s.charAt(i) + "<span>";
            }
        }
        lbText.setText(result);
    }

    String hiddenString = "PRJ31_THAYCACAC";

    //return a string move text one character
    private String shiftText(String s) {
        return s.substring(1) + s.charAt(0);
    }
    boolean kt = true;//to text run with color
    //get text with color text green and blue sequence

    private void putTextToLabel(String s) {
        String result = "<html>";
        lbText.setText(result);

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && kt || i % 2 == 1 && !kt) {
                result += "<span style='color: green'>" + s.charAt(i) + "<span>";
            } else {
                result += "<span style='color: blue'>" + s.charAt(i) + "<span>";
            }
        }
        kt = !kt;
        lbText.setText(result);
    }

    /*-------------------------------HOMEWORK---------------------------------*/
    //allow user move text right to left 2 character
    private void moveTextToLeftTwoChar() {
        String s = lbText.getText();
        s = s.substring(2) + s.charAt(0) + s.charAt(1);
        lbText.setText(s);
    }

    //allow user move text right to left 2 character
    private void moveTextToRightTwoChar() {
        String s = lbText.getText();
        s = s.charAt(s.length() - 2) + s.substring(0, s.length() - 2);
        lbText.setText(s);
    }

    //allow user move text right to left k character
    private void moveTextToLeftKChar(int k) {
        String s = lbText.getText();
        s = s.substring(k) + s.substring(0, k);
        lbText.setText(s);
    }

    //allow user move text right to left k character
    private void moveTextToRightKChar(int k) {
        String s = lbText.getText();
        s = s.charAt(s.length() - k) + s.substring(0, s.length() - k);
        lbText.setText(s);
    }

    /*------------------------------------------------------------------------*/
    //allow user set font name
    private void setFontName() {
        String fonts[]
                = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        cbbFontName.setModel(new DefaultComboBoxModel(fonts));
    }

    //allow user change font name
    private void changeFontName() {
        String fontName = cbbFontName.getSelectedItem().toString();
        int intdexStyle = cbbFontStyle.getSelectedIndex();
        int fontSize = lbText.getFont().getSize();
        lbText.setFont(new Font(fontName, fontSize, fontSize));
    }

    //allow user change font style when choose check box
    private void changeFontStyleByRadio(int fontStyle) {
        int fontSize = lbText.getFont().getSize();
        String fontName = lbText.getFont().getFontName();
        lbText.setFont(new Font(fontName, fontStyle, fontSize));
    }

    /*------------------------------------------------------------------------*/
    ////get text with color with (red blue yellow) and fix index color
    private void putTextThreeColorType1(String s) {
        String result = "<html>";
        lbText.setText(result);

        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 0) {
                result += "<span style='color: red'>" + s.charAt(i) + "<span>";
            } else if (i % 3 == 1) {
                result += "<span style='color: blue'>" + s.charAt(i) + "<span>";
            } else {
                result += "<span style='color: yellow'>" + s.charAt(i) + "<span>";
            }
        }
        result += "</html>";
        lbText.setText(result);
    }

    //get text with color with (red blue yellow) and color run with character
    int changeColor = 0;

    private void putTextThreeColorType2(String s) {
        String result = "<html>";
        lbText.setText(result);
        String[] colors = {"red", "blue", "yellow"};
        int colorStart = changeColor % 3;
        for (int i = 0; i < s.length(); i++) {
            result += "<span style='color: " + colors[colorStart++ % 3]
                    + "'>" + s.charAt(i) + "<span>";
        }
        changeColor++;
        lbText.setText(result);
    }

    //shift 2 color
    private String shiftTextTwoChar(String s) {
        return s.substring(2) + s.charAt(0) + s.charAt(1);
    }

    private void putTextTwoCharType1(String s) {
        String result = "<html>";
        lbText.setText(result);
        boolean check = true;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (check) {
                result += "<span style='color: red'>" + s.charAt(i) + "<span>";
                result += "<span style='color: red'>" + s.charAt(i + 1) + "<span>";
            } else {
                result += "<span style='color: yellow'>" + s.charAt(i) + "<span>";
                result += "<span style='color: yellow'>" + s.charAt(i + 1) + "<span>";
            }
            check = !check;
        }
        result += "</html>";
        lbText.setText(result);
    }

    boolean checkChange = true;

    private void putTextTwoCharType2(String s) {
        String result = "<html>";
        lbText.setText(result);

        if (checkChange) {
            boolean checkIndex = true;
            for (int i = 0; i < s.length() - 1; i += 2) {
                if (checkIndex) {
                    result += "<span style='color: red'>" + s.charAt(i) + "<span>";
                    result += "<span style='color: red'>" + s.charAt(i + 1) + "<span>";
                } else {
                    result += "<span style='color: yellow'>" + s.charAt(i) + "<span>";
                    result += "<span style='color: yellow'>" + s.charAt(i + 1) + "<span>";
                }
                checkIndex = !checkIndex;
            }
        } else {
            boolean checkIndex = true;
            for (int i = 0; i < s.length() - 1; i += 2) {
                if (checkIndex) {
                    result += "<span style='color: yellow'>" + s.charAt(i) + "<span>";
                    result += "<span style='color: yellow'>" + s.charAt(i + 1) + "<span>";
                } else {
                    result += "<span style='color: red'>" + s.charAt(i) + "<span>";
                    result += "<span style='color: red'>" + s.charAt(i + 1) + "<span>";
                }
                checkIndex = !checkIndex;
            }
        }
        checkChange =  !checkChange;

        result += "</html>";
        lbText.setText(result);
    }

    /*------------------------------------------------------------------------*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lbText = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        lbChooseMoveLeftRight = new javax.swing.JLabel();
        rdbMoveRight = new javax.swing.JRadioButton();
        rdbMoveLeft = new javax.swing.JRadioButton();
        cbChangeColor = new javax.swing.JCheckBox();
        lbMoreOption = new javax.swing.JLabel();
        cbChangeFont = new javax.swing.JCheckBox();
        cbTextRun = new javax.swing.JCheckBox();
        tfInputSpeed = new javax.swing.JTextField();
        lbOptionSpeed = new javax.swing.JLabel();
        sldSpeed = new javax.swing.JSlider();
        lbFontStyle = new javax.swing.JLabel();
        cbbFontStyle = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFontSize = new javax.swing.JList<>();
        lbFontSize = new javax.swing.JLabel();
        lbFontName = new javax.swing.JLabel();
        cbbFontName = new javax.swing.JComboBox<>();
        rdbRegular = new javax.swing.JRadioButton();
        rdbBold = new javax.swing.JRadioButton();
        rdbItalic = new javax.swing.JRadioButton();
        rdbBoldItalic = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbText.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbText.setText("PRJ311_THAYCACAC");

        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("STOP");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        lbChooseMoveLeftRight.setText("Choose move left or right: ");

        buttonGroup1.add(rdbMoveRight);
        rdbMoveRight.setText("Move Left To Right");

        buttonGroup1.add(rdbMoveLeft);
        rdbMoveLeft.setText("Move Right To Left");

        cbChangeColor.setText("Change Color");

        lbMoreOption.setText("More option:");

        cbChangeFont.setText("Change Font");

        cbTextRun.setText("Text Run");

        tfInputSpeed.setText("500");
        tfInputSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfInputSpeedActionPerformed(evt);
            }
        });

        lbOptionSpeed.setText("Option Speed: ");

        sldSpeed.setMajorTickSpacing(400);
        sldSpeed.setMaximum(2000);
        sldSpeed.setMinorTickSpacing(100);
        sldSpeed.setPaintLabels(true);
        sldSpeed.setPaintTicks(true);
        sldSpeed.setSnapToTicks(true);
        sldSpeed.setToolTipText("");
        sldSpeed.setValue(1000);
        sldSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSpeedStateChanged(evt);
            }
        });

        lbFontStyle.setText("Font Style");

        cbbFontStyle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Bold", "Italic", "Bold & Italic" }));
        cbbFontStyle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbFontStyleItemStateChanged(evt);
            }
        });

        listFontSize.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "10", "15", "20", "25", "30", "35", "40", "45", "50" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listFontSize.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFontSizeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listFontSize);

        lbFontSize.setText("Font Size");

        lbFontName.setText("Font Name");

        cbbFontName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbFontNameItemStateChanged(evt);
            }
        });

        buttonGroup2.add(rdbRegular);
        rdbRegular.setText("Regular");
        rdbRegular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbRegularMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdbBold);
        rdbBold.setText("Bold");
        rdbBold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbBoldMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdbItalic);
        rdbItalic.setText("Italic");
        rdbItalic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbItalicMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdbBoldItalic);
        rdbBoldItalic.setText("Bold & Italic");
        rdbBoldItalic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbBoldItalicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbbFontStyle, 0, 142, Short.MAX_VALUE)
                                .addComponent(lbChooseMoveLeftRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbMoveRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbMoveLeft)
                                .addComponent(lbFontStyle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rdbItalic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbRegular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbBold, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbBoldItalic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMoreOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbChangeColor, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(cbChangeFont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTextRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbFontSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbOptionSpeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfInputSpeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sldSpeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbFontName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(cbbFontName, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(lbText, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbText, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChooseMoveLeftRight)
                    .addComponent(lbMoreOption)
                    .addComponent(lbOptionSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbMoveRight)
                    .addComponent(cbChangeColor)
                    .addComponent(tfInputSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbMoveLeft)
                            .addComponent(cbChangeFont))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTextRun))
                    .addComponent(sldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFontStyle)
                    .addComponent(lbFontSize)
                    .addComponent(lbFontName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbFontName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rdbRegular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbBold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbItalic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbBoldItalic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbFontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        checkRun = true;
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        checkRun = false;
    }//GEN-LAST:event_btnStopActionPerformed

    //if user change value of slider bar, speed change
    private void sldSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSpeedStateChanged
        speed = Integer.toString(sldSpeed.getValue());
        tfInputSpeed.setText(speed);
    }//GEN-LAST:event_sldSpeedStateChanged

    //if user input speed then slide bar change, speed change
    private void tfInputSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfInputSpeedActionPerformed
        speed = tfInputSpeed.getText();
        try {
            sldSpeed.setValue(Integer.parseInt(speed));
        } catch (NumberFormatException e) {
            sldSpeed.setValue(100);
        }
    }//GEN-LAST:event_tfInputSpeedActionPerformed

    //if user change font style, text will be change
    private void cbbFontStyleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbFontStyleItemStateChanged
        int intdexStyle = cbbFontStyle.getSelectedIndex();
        String fontName = lbText.getFont().getFontName();
        int fontSize = lbText.getFont().getSize();
        lbText.setFont(new Font(fontName, intdexStyle, fontSize));
    }//GEN-LAST:event_cbbFontStyleItemStateChanged

    //if user change font font size, text will be change
    private void listFontSizeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFontSizeValueChanged
        int fontSize = Integer.parseInt(listFontSize.getSelectedValue());
        String fontName = lbText.getFont().getFontName();
        int fontStyle = lbText.getFont().getStyle();
        lbText.setFont(new Font(fontName, fontSize, fontSize));
    }//GEN-LAST:event_listFontSizeValueChanged

    private void cbbFontNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbFontNameItemStateChanged
        changeFontName();
    }//GEN-LAST:event_cbbFontNameItemStateChanged

    private void rdbRegularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbRegularMouseClicked
        changeFontStyleByRadio(0);
    }//GEN-LAST:event_rdbRegularMouseClicked

    private void rdbBoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbBoldMouseClicked
        changeFontStyleByRadio(1);
    }//GEN-LAST:event_rdbBoldMouseClicked

    private void rdbItalicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbItalicMouseClicked
        changeFontStyleByRadio(2);
    }//GEN-LAST:event_rdbItalicMouseClicked

    private void rdbBoldItalicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbBoldItalicMouseClicked
        changeFontStyleByRadio(3);
    }//GEN-LAST:event_rdbBoldItalicMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PRJ311.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRJ311.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRJ311.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRJ311.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRJ311().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbChangeColor;
    private javax.swing.JCheckBox cbChangeFont;
    private javax.swing.JCheckBox cbTextRun;
    private javax.swing.JComboBox<String> cbbFontName;
    private javax.swing.JComboBox<String> cbbFontStyle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChooseMoveLeftRight;
    private javax.swing.JLabel lbFontName;
    private javax.swing.JLabel lbFontSize;
    private javax.swing.JLabel lbFontStyle;
    private javax.swing.JLabel lbMoreOption;
    private javax.swing.JLabel lbOptionSpeed;
    private javax.swing.JLabel lbText;
    private javax.swing.JList<String> listFontSize;
    private javax.swing.JRadioButton rdbBold;
    private javax.swing.JRadioButton rdbBoldItalic;
    private javax.swing.JRadioButton rdbItalic;
    private javax.swing.JRadioButton rdbMoveLeft;
    private javax.swing.JRadioButton rdbMoveRight;
    private javax.swing.JRadioButton rdbRegular;
    private javax.swing.JSlider sldSpeed;
    private javax.swing.JTextField tfInputSpeed;
    // End of variables declaration//GEN-END:variables
}
