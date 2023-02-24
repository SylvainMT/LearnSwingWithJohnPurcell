package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.TooManyListenersException;

class FormPanel extends JPanel {

    private final JLabel nameLabel;
    private final JTextField nameField;
    private final JLabel occupationLabel;
    private final JTextField occupationField;
    private final JLabel ageLbl;
    private final JList<AgeCategory> ageList;
    private final JLabel empLbl;
    private final JComboBox<String> empCbx;
    private final JButton okBtn;
    private FormEventListener formEventListener;
    FormPanel() {
        Dimension dim = new Dimension(250, 10);
        setPreferredSize(dim);

        nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);
        occupationLabel = new JLabel("Occupation:");
        occupationField = new JTextField(10);
        ageLbl = new JLabel("Age:");
        ageList = new JList<>();
        empLbl = new JLabel("Employment:");
        empCbx = new JComboBox<>();
        okBtn = new JButton("OK");

        setupAgeList();
        setupEmpCbx();
        setupOkBtn();
        addBorder();
        layoutComponents();
    }

    private void setupEmpCbx() {
        String[] employmentOptions = new String[] {"employed", "self-employed", "unemployed"};
        DefaultComboBoxModel<String> empModel = new DefaultComboBoxModel<>(employmentOptions);
        empCbx.setModel(empModel);

    }

    private void setupOkBtn() {
        okBtn.addActionListener((ActionEvent ae) -> {
            String name = nameField.getText();
            String occupation = occupationField.getText();
            AgeCategory age = ageList.getSelectedValue();
            Object empCbxSelectedItem = empCbx.getSelectedItem();
            String emp = (empCbxSelectedItem instanceof String) ? (String) empCbxSelectedItem : "";

            notifyFormEventListeners(new FormEvent(this, name, occupation, age, emp));
        });
    }

    private void setupAgeList() {
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
    }

    private void layoutComponents() {
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

        //Row 3 Column 1
        gc.gridy = 2;
        gc.gridx = 0;
        gc.insets = labelCellInset;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(ageLbl, gc);

        //Row 3 Column 2
        gc.gridx = 1;
        gc.insets = defaultCellInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ageList, gc);

        //Row 4 Column 1
        gc.gridy = 3;
        gc.gridx = 0;
        gc.insets = labelCellInset;
        gc.anchor = GridBagConstraints.LINE_END;
        add(empLbl, gc);

        //Row 4 Column 2
        gc.gridx = 1;
        gc.insets = defaultCellInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(empCbx, gc);

        //Row 5 column 2
        gc.gridy = 4;
        gc.weighty = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    private void addBorder() {
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border panelBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        setBorder(panelBorder);
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
