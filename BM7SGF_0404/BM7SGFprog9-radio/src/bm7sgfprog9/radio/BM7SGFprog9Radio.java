
package bm7sgfprog9.radio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BM7SGFprog9Radio extends JFrame {
    private JTextField textField;
    private JRadioButton redRadio;
    private JRadioButton blueRadio;
    private JRadioButton smallRadio;
    private JRadioButton largeRadio;

    public BM7SGFprog9Radio() {
        setTitle("Betűszín és Betűméret Váltó");
        setSize(250, 350); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(15);
        add(textField);

        JButton clearButton = new JButton("Törlés"); 
        add(clearButton);

        ButtonGroup colorGroup = new ButtonGroup();
        redRadio = new JRadioButton("Piros");
        blueRadio = new JRadioButton("Kék");
        colorGroup.add(redRadio);
        colorGroup.add(blueRadio);
        JPanel colorPanel = new JPanel();
        colorPanel.add(redRadio);
        colorPanel.add(blueRadio);
        add(colorPanel);

        ButtonGroup sizeGroup = new ButtonGroup();
        smallRadio = new JRadioButton("Kisbetű");
        largeRadio = new JRadioButton("Nagybetű");
        sizeGroup.add(smallRadio);
        sizeGroup.add(largeRadio);
        JPanel sizePanel = new JPanel();
        sizePanel.add(smallRadio);
        sizePanel.add(largeRadio);
        add(sizePanel);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(""); 
            }
        });

        redRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeTextColor(Color.RED);
            }
        });

        blueRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeTextColor(Color.BLUE);
            }
        });

        smallRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeTextSize(12);
            }
        });

        largeRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeTextSize(24);
            }
        });
    }

    private void changeTextColor(Color color) {
        textField.setForeground(color);
    }

    private void changeTextSize(int size) {
        Font font = textField.getFont();
        textField.setFont(new Font(font.getFontName(), font.getStyle(), size));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BM7SGFprog9Radio().setVisible(true);
            }
        });
    }
}
