
package bm7sgf_kepek;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BM7SGF_Kepek {

    public static void main(String args[]) throws IOException {
        JFrame ablak = new JFrame();
        ablak.setSize(940, 400);

        String imagePath = "C:\\Users\\kvnpa\\Documents\\NetBeansProjects\\BM7SGF_Kepek\\src\\bm7sgf_kepek\\the.jpg";
        BufferedImage kep = ImageIO.read(new File(imagePath));

        BufferedImage kep1 = resize(kep, 100, 75);
        BufferedImage kep2 = resize(kep, 200, 150);
        BufferedImage kep3 = resize(kep, 400, 300);

        JLabel keplabel1 = new JLabel(new ImageIcon(kep1));
        JLabel keplabel2 = new JLabel(new ImageIcon(kep2));
        JLabel keplabel3 = new JLabel(new ImageIcon(kep3));

        JPanel jPanel = new JPanel();
        jPanel.add(keplabel1);
        jPanel.add(keplabel2);
        jPanel.add(keplabel3);

        ablak.add(jPanel);

        ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ablak.setVisible(true);
    }

    private static BufferedImage resize(BufferedImage img, int newWidth, int newHeight) {
        BufferedImage resizedImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        resizedImg.getGraphics().drawImage(img, 0, 0, newWidth, newHeight, null);
        return resizedImg;
    }
}
