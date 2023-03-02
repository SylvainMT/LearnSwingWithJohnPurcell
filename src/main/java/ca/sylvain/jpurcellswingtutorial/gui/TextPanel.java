package ca.sylvain.jpurcellswingtutorial.gui;

import javax.swing.*;
import java.awt.*;

class TextPanel extends JPanel {
    private final JTextArea textArea;
    TextPanel() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    void appendText(String text) {
        textArea.append(text);
    }
}
