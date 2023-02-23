package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.awt.*;
import java.util.TooManyListenersException;

class MainFrame extends JFrame {
    private final TextPanel textPanel;
    private final Toolbar toolbar;
    private final FormPanel formPanel;
    MainFrame () {
        super("Hello World");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        toolbar.setStringListener(textPanel::appendText);
        try {
            formPanel.addFormEventListener((FormEvent fe) -> {
                textPanel.appendText("Name: " + fe.getName() + " & Occupation: " + fe.getOccupation() + "\n");
            });
        } catch (TooManyListenersException e) {
            throw new RuntimeException(e);
        }


        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
