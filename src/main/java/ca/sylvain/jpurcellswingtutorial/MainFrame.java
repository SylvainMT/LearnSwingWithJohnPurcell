package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {
    private TextPanel textPanel;
    private Toolbar toolbar;
    MainFrame () {
        super("Hello World");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();

        toolbar.setStringListener((String text) -> {
            textPanel.appendText(text);
        });


        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
