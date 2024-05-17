package bm7sgf_2d_grafika;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;

public class BM7SGF_2d_grafika {

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Grafika");
        CanvasDemo canvas = new CanvasDemo();
        frame.add(canvas);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static class CanvasDemo extends Canvas {

        private final Image universityLogo;

        public CanvasDemo() {
            setBackground(Color.GRAY);
            setSize(500, 500);
            universityLogo = Toolkit.getDefaultToolkit().getImage("C:\\Users\\kvnpa\\Documents\\NetBeansProjects\\BM7SGF_2d_grafika\\src\\bm7sgf_2d_grafika\\the.jpg");
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            // Első ovális clip
            Ellipse2D clip1 = new Ellipse2D.Double(120, 150, 180, 105);
            g2d.setClip(clip1);
            GradientPaint gradient = new GradientPaint(120, 150, Color.RED, 300, 255, Color.YELLOW, true);
            g2d.setPaint(gradient);
            g2d.fill(clip1);

            // Második ovális clip
            Ellipse2D clip2 = new Ellipse2D.Double(200, 150, 250, 200);
            g2d.setClip(clip2);
            g2d.setColor(Color.BLUE);
            g2d.fill(clip2);

            // Clip eltávolítása és eredeti állapot visszaállítása
            g2d.setClip(null);

            // Logó elforgatása és rajzolása
            double transparency1 = 0.8;
            g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, (float) transparency1));

            AffineTransform oldTransform = g2d.getTransform();
            g2d.rotate(Math.toRadians(-25), 250, 125);
            g2d.drawImage(universityLogo, 40, 120, 300, 150, this);
            g2d.setTransform(oldTransform);

            // Szöveg rajzolása
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Tokaj-Hegyalja Egyetem", 200, 50);
        }
    }
}
