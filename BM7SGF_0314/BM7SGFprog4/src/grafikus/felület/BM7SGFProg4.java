
package grafikus.felület;

import javax.swing.*;

public class BM7SGFProg4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grafikus felület");
        frame.setSize(400, 300);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Helló BM7SGF!");
        frame.getContentPane().add(label);

        label.setBounds(40,100,100,20);
        
        frame.setVisible(true);
    }
}

