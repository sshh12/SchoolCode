//Shrivu Shankar
//Period 5
//11/3/16

import java.awt.*;
import javax.swing.*;

public class KochCurveFractal extends JFrame {

    public KochCurveFractal() {
        setTitle("Fractals");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawingPanel());
        pack();
        //centers the frame
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (screensize.width - getWidth())), (int) (.5 * (screensize.height - getHeight())), getWidth(), getHeight());
        setSize(new Dimension(500, 500));
    }

    public static void main(String[] args) {
        new KochCurveFractal();
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
            drawFractal(level, 190, 190, 120, 100, g);

            g.setColor(Color.PINK);
            drawFractal(level, 190, 190, 75, 220, g);

            g.setColor(Color.ORANGE);
            drawFractal(level, 190, 190, 190, 300, g);

            g.setColor(Color.GREEN);
            drawFractal(level, 190, 190, 310, 220, g);
            g.setColor(Color.RED);
            drawFractal(level, 190, 190, 270, 100, g);
        }

        public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g) {

            if (level == 0) {
                g.drawLine(xA, yA, xB, yB);
            } else {
                
                int xC = (xA + xB) / 2;
                int yC = (yA + yB) / 2;

                int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
                int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
                
                drawFractal(level - 1, xD, yD, xB, yB, g);
                
                drawFractal(level - 1, xA, yA, xD, yD, g);
                
                drawFractal(level - 1, xC, yC, xD, yD, g);

            }

        }
    }
}
