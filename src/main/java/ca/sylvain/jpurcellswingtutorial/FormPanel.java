package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.TooManyListenersException;

class FormPanel extends JPanel {

    private final JLabel nameLabel;
    private final JLabel occupationLabel;
    private final JTextField nameField;
    private final JTextField occupationField;
    private final JButton okBtn;
    private final JList<AgeCategory> ageList;
    private FormEventListener formEventListener;
    FormPanel() {
        Dimension dim = new Dimension(250, 10);
        setPreferredSize(dim);

        nameLabel = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList<>();
        okBtn = new JButton("OK");

        DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
        ageModel.addElement(AgeCategory.UNDER18);
        ageModel.addElement(AgeCategory.BETWEEN18AND65);
        ageModel.addElement(AgeCategory.OVER65);

        ageList.setModel(ageModel);
        ageList.setSelectedIndex(1);
        double lineHeight = nameField.getPreferredSize().getHeight();
        int ageListPreferredHeight = (int) Math.round(lineHeight * 3.2);
        int ageListPreferredWidth = (int) nameField.getPreferredSize().getWidth();
        Dimension ageListPreferredSize = new Dimension(ageListPreferredWidth, ageListPreferredHeight);
        ageList.setPreferredSize(ageListPreferredSize);

        okBtn.addActionListener((ActionEvent ae) -> {
            String name = nameField.getText();
            String occupation = occupationField.getText();
            AgeCategory age = ageList.getSelectedValue();

            notifyFormEventListeners(new FormEvent(this, name, occupation, age));
        });

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border panelBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        setBorder(panelBorder);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        Insets labelCellInset = new Insets(0, 0, 0, 5);
        Insets defaultCellInset = new Insets(0, 0, 0, 0);

        //Cell Defaults
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;


        //Row 1 Column 1
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = labelCellInset;
        add(nameLabel, gc);

        //Row 1 Column 2
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = defaultCellInset;
        add(nameField, gc);

        //Row 2 Column 1
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = labelCellInset;
        add(occupationLabel, gc);

        //Row 2 Column 2
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = defaultCellInset;
        add(occupationField, gc);

        //Row 3 Column 2
        gc.gridy = 2;
        add(ageList, gc);

        //Row 4 Column 2
        gc.gridy = 3;
        gc.weighty = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

    }

    public void addFormEventListener(FormEventListener formEventListener) throws TooManyListenersException {
        if (formEventListener == null) {
            throw new NullPointerException();
        }

        if (this.formEventListener != null) {
            throw new TooManyListenersException();
        }

        this.formEventListener = formEventListener;
    }

    private void notifyFormEventListeners(FormEvent fe) {
        if (formEventListener == null) {
            return;
        }
        formEventListener.formEventOccurred(fe);
    }
}
