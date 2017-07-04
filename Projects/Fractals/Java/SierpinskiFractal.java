//Shrivu Shankar
//Period 5
//11/3/16

import java.awt.*;
import javax.swing.*;

public class SierpinskiFractal extends JFrame {

    public SierpinskiFractal() {
        setTitle("Fractals");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel());
        pack();
        //centers the frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
        setSize(new Dimension(800, 800));
    }

    public static void main(String[] args) {
        new SierpinskiFractal();
    }

    private class DrawingPanel extends JPanel {

        int level = 0;

        public DrawingPanel() {
            super();

            JLabel label = new JLabel("Level: " + level);

            JButton plus = new JButton("+");
            plus.addActionListener((e) -> {
                label.setText("Level: " + ++level);
                this.repaint();
            });

            JButton minus = new JButton("-");
            minus.addActionListener((e) -> {
                label.setText("Level: " + --level);
                this.repaint();
            });

            add(plus);
            add(minus);
            add(label);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.setColor(Color.BLUE);
            drawFractal(level, 300, 300, 200, g);

        }

        public void drawFractal(int level, int x, int y, int s, Graphics g) {

            g.fillRect(x, y, s, s);
            
            if (level > 0) {
                
                int x1 = x - 2*s/3;
                int x2 = x + s/3;
                int x3 = x + s + s/3;
                
                int y1 = y - 2*s/3;
                int y2 = y + s/3;
                int y3 = y + s + s/3;
   
                
                drawFractal(level - 1, x1, y1, s/3, g);
                drawFractal(level - 1, x1, y2, s/3, g);
                drawFractal(level - 1, x1, y3, s/3, g);
                
                drawFractal(level - 1, x2, y1, s/3, g);
                drawFractal(level - 1, x2, y3, s/3, g);
                
                drawFractal(level - 1, x3, y1, s/3, g);
                drawFractal(level - 1, x3, y2, s/3, g);
                drawFractal(level - 1, x3, y3, s/3, g);
               

            }

        }
    }
}
