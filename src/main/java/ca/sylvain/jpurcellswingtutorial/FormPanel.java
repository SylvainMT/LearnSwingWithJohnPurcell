package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class FormPanel extends JPanel {

    private final JLabel nameLabel;
    private final JLabel occupationLabel;
    private final JTextField nameField;
    private final JTextField occupationField;
    private final JButton okBtn;
    FormPanel() {
        Dimension dim = new Dimension(250, 10);
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OK");

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border panelBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        setBorder(panelBorder);
    }
}
