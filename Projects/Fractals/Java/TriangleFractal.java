//Shrivu Shankar
//Period 5
//11/3/16

import java.awt.*;
import javax.swing.*;

public class TriangleFractal extends JFrame {

    public TriangleFractal() {
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
        new TriangleFractal();
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
            drawFractal(g, new Point((800 - 10) / 2, 20), new Point(800 - 40, 800 - 20), new Point(40, 800 - 20), level);

        }

        public void drawFractal(Graphics g, Point a, Point b, Point c, int level) {

            drawTriangle(g, a, b, c);
            if (level > 0) {
                g.setColor(Color.BLUE);
                drawFractal(g, getMP(a, b), b, getMP(b, c), level - 1);
                g.setColor(Color.RED);
                drawFractal(g, a, getMP(a, b), getMP(a, c), level - 1);
                g.setColor(Color.GREEN);
                drawFractal(g, getMP(a, c), getMP(b, c), c, level - 1);
            }

        }

        private Point getMP(Point a, Point b) {//MidPoint
            return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
        }

        private void drawTriangle(Graphics g, Point a, Point b, Point c) {
            g.drawLine(a.x, a.y, b.x, b.y);
            g.drawLine(c.x, c.y, b.x, b.y);
            g.drawLine(a.x, a.y, c.x, c.y);
        }
    }
}
