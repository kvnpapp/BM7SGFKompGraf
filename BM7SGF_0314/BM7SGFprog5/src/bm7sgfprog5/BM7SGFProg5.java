
package bm7sgfprog5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BM7SGFProg5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BM7SGF Program 5");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Kilépés");
        button.setBounds(150, 100, 100, 50);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(button);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
