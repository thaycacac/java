/**
 *
 * @author THAYCACAC
 */

//move text right to left
    private void moveTextRightToLeft() {
        String s = lbText.getText();
        s = s.substring(1) + s.charAt(0);
        lbText.setText(s);
    }

//move text right to left
    private void moveTextLeftToRight() {
        String s = lbText.getText();
        s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        lbText.setText(s);
    }

//move text right to left k character
    private void moveTextToLeftKChar(int k) {
        String s = lbText.getText();
        s = s.substring(k) + s.substring(0, k);
        lbText.setText(s);
    }

//move text right to left k character
    private void moveTextToRightKChar(int k) {
        String s = lbText.getText();
        s = s.charAt(s.length() - k) + s.substring(0, s.length() - k);
        lbText.setText(s);
    }

//change color then color of text will change -> red -> yello -> 
    private void changeColor() {
        Color color = lbText.getForeground();
        if (color == Color.BLACK) lbText.setForeground(Color.RED);
        else if (color == Color.RED) lbText.setForeground(Color.YELLOW);
        else if (color == Color.YELLOW) lbText.setForeground(Color.BLUE);
        else if (color == Color.BLUE) lbText.setForeground(Color.GREEN);
        else lbText.setForeground(Color.BLACK);
    }

//change all font(font size, font style, name)
    int fontStyle = 0; int fontSize = 15; 
    String[] fontName = {"Times", "Italic", "Verdana"}; int count = 0;
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
            if (i % 2 == 0) result += "<span style='color: green'>" + s.charAt(i) + "<span>";
            else result += "<span style='color: blue'>" + s.charAt(i) + "<span>";
        }
        lbText.setText(result);
    }

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
        kt = !kt; lbText.setText(result);
    }

//change font name
    private void changeFontNameByComboBox() {
        String fontName = cbbFontName.getSelectedItem().toString();
        int style = lbText.getFont().getStyle();
        int size = lbText.getFont().getSize();
        lbText.setFont(new Font(fontName, style, size));
    }

/*change font style
    0 Regular
    1 Bold
    2 Italic
    3 Bold & Italic
*/
    private void changeFontStyleByComboBox() {
        int style = cbbFontStyle.getSelectedItem().toString();
        int name = lbText.getFont().getName();
        int size = lbText.getFont().getSize();
        lbText.setFont(new Font(fontName, style, size));
    }

//change font name
private void changeFontStyleByComboBox() {
        int style = cbbFontStyle.getSelectedItem().toString();
        int name = lbText.getFont().getName();
        int size = lbText.getFont().getSize();
        lbText.setFont(new Font(fontName, style, size));
    }

//change font size
    private void changeFontSizeByComboBox() {
        int size = cbbFontSize.getSelectedItem().toString();
        int style = lbText.getFont().getStyle();
        int name = lbText.getFont().getName();
        lbText.setFont(new Font(fontName, style, size));
    }

//simple format
    String timeStamp = new SimpleDateFormat("ss/mm/HH").format(Calendar.getInstance().getTime());