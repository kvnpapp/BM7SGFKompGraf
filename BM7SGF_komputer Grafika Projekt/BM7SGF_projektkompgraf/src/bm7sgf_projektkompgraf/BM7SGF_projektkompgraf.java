package bm7sgf_projektkompgraf;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BM7SGF_projektkompgraf extends JPanel {
    private BufferedImage image;

    public BM7SGF_projektkompgraf() {
        // Kép betöltése
        try {
            image = ImageIO.read(new File("C:\\Users\\kvnpa\\Documents\\NetBeansProjects\\BM7SGF_beadandokompgraf\\src\\bm7sgf_beadandokompgraf\\the.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.setColor(Color.RED);
            g.fillRect(0, 0, 600, 600);
            g.setColor(Color.BLACK);
            g.drawString("Kép nem található", 250, 300);
            g.dispose();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        HeartShape heart = new HeartShape(100, 100, 600); 
        g2d.setColor(Color.RED);
        g2d.fill(heart);

        Area heartArea = new Area(heart);
        heartArea.intersect(new Area(new Rectangle(100, 100, 600, 600)));
        g2d.setClip(heartArea);
        g2d.drawImage(image, 100, 100, 600, 600, this);
        g2d.setClip(null);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("Tokaj-Hegyalja Egyetem", 220, 750); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BM7SGF_projektkompgraf());
        frame.setSize(800, 800); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


class HeartShape extends java.awt.geom.Path2D.Double {
    public HeartShape(int x, int y, int width) {
        super();
        double w = width * 0.5;
        double h = width * 0.8;
        moveTo(x + w, y + h);
        curveTo(x + w, y + h - 0.3 * h, x + w - 0.5 * w, y + h - 0.8 * h, x + w - 0.5 * w, y + 0.2 * h);
        curveTo(x + w - 0.5 * w, y - 0.6 * h, x + w, y - 0.9 * h, x + w, y + 0.2 * h);
        curveTo(x + w, y - 0.9 * h, x + w + 0.5 * w, y - 0.6 * h, x + w + 0.5 * w, y + 0.2 * h);
        curveTo(x + w + 0.5 * w, y + h - 0.8 * h, x + w, y + h - 0.3 * h, x + w, y + h);
        closePath();
    }
}
