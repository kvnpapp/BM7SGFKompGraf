
package bm7sgfprog11;

import javax.swing.*;
import java.awt.*;

public class BM7SGFprog11 extends JFrame {
    public BM7SGFprog11() {
        setTitle("PTi");
        setSize(220, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        JPanel topPanel = new JPanel();
        JLabel label = new JLabel("Programtervező informatikus");
        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        String[] nevek = {"Papp Kevin", "Mihály Károly", "Laczkó Lajos", "Bárdos Triszten Krisztofer", "Veres Zoltán"};
        JList<String> nevLista = new JList<>(nevek);
        JScrollPane scrollPane = new JScrollPane(nevLista);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BM7SGFprog11().setVisible(true);
        });
    }
}
