package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class MainFrame extends JFrame {
    private TextPanel textPanel;
    private JButton btn;
    MainFrame () {
        super("Hello World");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        btn = new JButton("Click Me!");

        btn.addActionListener((ActionEvent ae) -> {
            textPanel.appendText("Hello\n");
        });

        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
