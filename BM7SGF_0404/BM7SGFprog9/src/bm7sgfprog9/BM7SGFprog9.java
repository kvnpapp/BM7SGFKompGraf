package bm7sgfprog9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BM7SGFprog9 extends JFrame {
    private JTextField textField;
    private JCheckBox colorCheckBox;
    private JCheckBox sizeCheckBox;

    public BM7SGFprog9() {
        setTitle("Betűszín és Betűméret Váltó");
        setSize(350, 250); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(15);
        add(textField);

        JButton clearButton = new JButton("Törlés");
        add(clearButton);

        colorCheckBox = new JCheckBox("Piros és Kék Betűszín");
        add(colorCheckBox);

        sizeCheckBox = new JCheckBox("Kis és Nagybetű");
        add(sizeCheckBox);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(""); 
            }
        });

        colorCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    changeTextColor();
                } else {
                    changeTextColor(); 
                }
            }
        });

        sizeCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    changeTextSize();
                } else {
                    changeTextSize(); 
                }
            }
        });
    }


    private void changeTextColor() {
        if (colorCheckBox.isSelected()) {
            textField.setForeground(Color.RED);
        } else {
            textField.setForeground(Color.BLUE);
        }
    }


    private void changeTextSize() {
        Font font = textField.getFont();
        int style = font.getStyle();
        float size = font.getSize();

        if (sizeCheckBox.isSelected()) {
            textField.setFont(new Font(font.getFontName(), style, (int) (size + 5))); 
        } else {
            textField.setFont(new Font(font.getFontName(), style, (int) (size - 5)));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BM7SGFprog9().setVisible(true);
            }
        });
    }
}
