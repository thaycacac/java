
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Kame
 */

public class Main extends Applet implements ActionListener {

    TextField aInput, bInput, cInput, tx;
    static TextField from, to;
    boolean notFirst;
    Button calcButton, saveButton, quitButton;
    int size = 400;
    static double a = 2, b = 1, c = 0;
    JMenu menu;
    JFrame f = new JFrame("Graph Quadratic");

    @Override
    public void resize(int width, int height) {
        super.resize(800, 550);
    }

    public void main(String[] args) {
        final Applet applet = new Main();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }

    public void init() {
        // setBackground(Color.GRAY);
        setLayout(null);
        setLocation(50, 50);
        resize(700, 470);
        from = new TextField("-2", 5);
        from.setBounds(412, 80, 80, 20);
        add(from);
        to = new TextField("1", 5);
        to.setBounds(560, 80, 80, 20);
        add(to);

        JMenuItem i1, i2, i3, i4, i5;
        JFrame f = new JFrame("Menu and MenuItem Example");
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Menu");
        i1 = new JMenuItem("Item 1");
        i2 = new JMenuItem("Item 2");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 4");
        i5 = new JMenuItem("Item 5");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        add(menu);

        Label labelA = new Label("Input equation:");
        labelA.setBounds(412, 40, 100, 20);
        aInput = new TextField();
        aInput.setBounds(520, 40, 150, 20);
        calcButton = new Button("Draw");
        calcButton.setBounds(460, 130, 45, 20);
        saveButton = new Button("Save");
        saveButton.setBounds(460, 170, 90, 20);
        quitButton = new Button("Quit");
        quitButton.setBounds(460, 210, 90, 20);
        add(labelA);
        add(aInput);
        add(calcButton);
        add(saveButton);
        add(quitButton);
        aInput.addActionListener(this);
        calcButton.addActionListener(this);
        saveButton.addActionListener(this);
        quitButton.addActionListener(this);
        notFirst = false;
    }

    public void makeGraph(Graphics g) {
        setLocation(100, 100);
        g.setColor(Color.lightGray);
        // Draw grid
        for (int y = 0; y <= size; y = y + 20) {
            g.drawLine(1, y, size, y);
        }
        for (int x = 0; x <= size; x = x + 20) {
            g.drawLine(x, 1, x, size);
        }
        g.setColor(Color.black);
        // Draw y axis
        g.drawLine(size / 2, 0, size / 2, size);
        for (int i = 0; i <= size; i = i + 20) {
            g.drawLine(size / 2 - 5, i, size / 2 + 5, i);
        }
        g.setColor(Color.black);
        // Draw x axis
        g.drawLine(0, size / 2, size, size / 2);
        for (int j = 0; j <= size; j = j + 20) {
            g.drawLine(j, size / 2 - 5, j, size / 2 + 5);
        }
        g.setColor(Color.BLACK);
        // Draw positive x axis numbers
        for (int n = 0; n <= 5; n++) {
            g.drawString("" + n * 2, (size / 2 - 4) + n * 40, size / 2 + 17);
        }
        // Draw negative x axis numbers
        for (int n = 1; n <= 5; n++) {
            g.drawString("-" + n * 2, (size / 2 - 6) - n * 40, size / 2 + 17);
        }
        // Draw positive y axis numbers
        for (int n = 1; n <= 5; n++) {
            g.drawString("" + n * 2, size / 2 - 21, (size / 2 + 5) - n * 40);
        }
        // Draw negative y axis numbers
        for (int n = 1; n <= 5; n++) {
            g.drawString("-" + n * 2, size / 2 - 23, (size / 2 + 6) + n * 40);
        }
    }

    public void paint(Graphics g) {
        int yValue = 180;
        makeGraph(g);
        g.drawString("f(x)= ax + bx + c", 20, 20);
        if (notFirst) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setBackground(Color.WHITE);
            g2.clearRect(0, 0, this.getWidth(), this.getHeight());
            makeGraph(g);
            g2.setStroke(new BasicStroke(0));
            g.setColor(Color.blue);
            String text1 = from.getText();
            String text2 = to.getText();
            double t1 = Double.parseDouble(text1);
            double t2 = Double.parseDouble(text2);
            g.setColor(Color.blue);
            for (double x = t1; x <= t2; x = x + 0.001) {
                double y = a * x * x + b * x + c; // double y = a * x * x + b * x + c;
                int X = (int) Math.round(200 + x * 19); // chinh toa do o 20
                int Y = (int) Math.round(200 - y * 19);

                g.fillOval(X - 2, Y - 2, 1, 1);
            }
            String equation = "f(x)=" + aInput.getText();
            g.setColor(Color.BLACK);
            g.drawString(equation, 20, 20);
        }
    }

    public void paintToSaveImage(Graphics g) {
        int yValue = 180;
        makeGraph(g);
        if (notFirst) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setBackground(Color.WHITE);
            g2.clearRect(0, 0, this.getWidth(), this.getHeight());
            makeGraph(g);
            g2.setStroke(new BasicStroke(0));
            g.setColor(Color.blue);
            String text1 = from.getText();
            String text2 = to.getText();
            double t1 = Double.parseDouble(text1);
            double t2 = Double.parseDouble(text2);
            g.setColor(Color.blue);
            for (double x = t1; x <= t2; x = x + 0.001) {
                double y = a * x * x + b * x + c; // double y = a * x * x + b * x + c;
                int X = (int) Math.round(200 + x * 19); // chinh toa do o 20
                int Y = (int) Math.round(200 - y * 19);
                g.drawOval(X - 2, Y - 2, 1, 1);
            }
            String equation = "f(x)=" + aInput.getText();
            g.setColor(Color.BLACK);
            g.drawString(equation, 20, 20);
        }
    }

    public void actionPerformed(ActionEvent e) {
        notFirst = true;
        Main m = new Main();
        Check check = new Check();
        String text = aInput.getText();
        if (e.getSource() == calcButton) {
            a = check.quadParseA(text);
            b = check.quadParseB(text);
            c = check.quadParseC(text);
            if (aInput.getText().equals("")) {
                a = 0;
            }
            repaint();
        }
        if (e.getSource() == saveButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int result = fileChooser.showSaveDialog(menu);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String extension = "";
                String fileName = file.toString();
                int i = fileName.lastIndexOf('.');
                int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
                if (i > p) {
                    extension = fileName.substring(i + 1);
                }
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = (Graphics2D) image.getGraphics();
                paintToSaveImage(g2);
                try {
                    ImageIO.write(image, extension, file);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
}
