package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class FormPanel extends JPanel {
    FormPanel() {
        Dimension dim = new Dimension(250, 10);
        setPreferredSize(dim);

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border panelBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        setBorder(panelBorder);
    }
}
