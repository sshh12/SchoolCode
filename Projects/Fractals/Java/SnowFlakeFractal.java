//Shrivu Shankar
//Period 5
//11/3/16

import java.awt.*;
import javax.swing.*;

public class SnowFlakeFractal extends JFrame {

    public SnowFlakeFractal() {
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
        new SnowFlakeFractal();
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
            drawFractal(g, level, 200, 100, 300, 273, 200, -60, 1);
            drawFractal(g, level, 100, 273, 200, 100, 200, 60, 1);
            drawFractal(g, level, 100, 273, 300, 273, 200, 0, -1);

        }

        public void drawFractal(Graphics g, int level, double xA, double yA, double xB, double yB, double length, int angle, int direction) {
            if (level <= 0) {
                g.drawLine((int) xA, (int) yA, (int) xB, (int) yB);
                return;
            }

            double newX = (xB / 3 + 2 * xA / 3) + length / 3 * Math.cos(Math.toRadians(angle + 60 * direction));
            double newY = (yB / 3 + 2 * yA / 3) - length / 3 * Math.sin(Math.toRadians(angle + 60 * direction));

            drawFractal(g, level - 1, xA, yA, xB / 3 + 2 * xA / 3, yB / 3 + 2 * yA / 3, length / 3, angle, direction);

            drawFractal(g, level - 1, xB / 3 + 2 * xA / 3, yB / 3 + 2 * yA / 3, newX, newY, length / 3, angle + 60 * direction, direction);

            drawFractal(g, level - 1, 2 * xB / 3 + xA / 3, 2 * yB / 3 + yA / 3, newX, newY, length / 3, angle + 120 * direction, -1 * direction);

            drawFractal(g, level - 1, 2 * xB / 3 + xA / 3, 2 * yB / 3 + yA / 3, xB, yB, length / 3, angle, direction);

        }

        private void drawTriangle(Graphics g, Point a, Point b, Point c) {
            g.drawLine(a.x, a.y, b.x, b.y);
            g.drawLine(c.x, c.y, b.x, b.y);
            g.drawLine(a.x, a.y, c.x, c.y);
        }
    }
}
