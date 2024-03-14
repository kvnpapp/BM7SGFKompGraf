package bm7sgfprog6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BM7SGFProg6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BM7SGF Program 6");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exitButton = new JButton("Kilépés");
        exitButton.setBounds(350, 350, 100, 50);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(exitButton);

        JButton printButton = new JButton("Működik");
        printButton.setBounds(200, 350, 150, 50);
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("Működik");
            }
        });
        frame.add(printButton);

        JButton prevButton = new JButton("Előző");
        prevButton.setBounds(100, 350, 100, 50);
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setTitle("Előző");
            }
        });
        frame.add(prevButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}

