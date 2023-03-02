package ca.sylvain.jpurcellswingtutorial.gui;

import ca.sylvaint.jpurcellswingtutorial.model.AgeCategory;
import ca.sylvaint.jpurcellswingtutorial.model.Gender;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.TooManyListenersException;

class FormPanel extends JPanel {

    private final JLabel nameLbl;
    private final JTextField nameTxt;
    private final JLabel occupationLbl;
    private final JTextField occupationTxt;
    private final JLabel ageLbl;
    private final JList<AgeCategory> ageLst;
    private final JLabel empLbl;
    private final JComboBox<String> empCbo;
    private final JLabel cndCitizenLbl;
    private final JCheckBox cndCitizenChk;
    private final JLabel taxLbl;
    private final JTextField taxTxt;
    private final JLabel genderLbl;
    private final EnumButtonGroup<Gender> genderOptionGroup;
    private final JButton okBtn;
    private FormEventListener formEventListener;
    FormPanel() {
        Dimension dim = new Dimension(250, 10);
        setPreferredSize(dim);

        nameLbl = new JLabel("Name:");
        nameTxt = new JTextField(10);
        occupationLbl = new JLabel("Occupation:");
        occupationTxt = new JTextField(10);
        ageLbl = new JLabel("Age:");
        ageLst = new JList<>();
        empLbl = new JLabel("Employment:");
        empCbo = new JComboBox<>();
        cndCitizenLbl = new JLabel("Cdn Citizen:");
        cndCitizenChk = new JCheckBox();
        taxLbl = new JLabel("Tax ID:");
        taxTxt = new JTextField(10);
        genderLbl = new JLabel("Gender:");
        genderOptionGroup = new EnumButtonGroup<>(Gender.MALE, EnumButtonGroup.VERTICAL_GROUP);
        okBtn = new JButton("OK");

        //Set up Mnemomics
        okBtn.setMnemonic(KeyEvent.VK_O);
        nameLbl.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLbl.setLabelFor(nameTxt);

        setupAgeLst();
        setupEmpCbx();
        setupCitizenNTax();
        setupOkBtn();
        addBorder();
        layoutComponents();
    }

    private void setupCitizenNTax() {
        taxLbl.setEnabled(false);
        taxTxt.setEnabled(false);

        cndCitizenChk.addActionListener((ActionEvent ae) -> {
            boolean taxFieldEnabled = cndCitizenChk.isSelected();
            taxLbl.setEnabled(taxFieldEnabled);
            taxTxt.setEnabled(taxFieldEnabled);
        });
    }

    private void setupEmpCbx() {
        String[] employmentOptions = new String[] {"employed", "self-employed", "unemployed"};
        DefaultComboBoxModel<String> empModel = new DefaultComboBoxModel<>(employmentOptions);
        empCbo.setModel(empModel);

    }

    private void setupOkBtn() {
        okBtn.addActionListener((ActionEvent ae) -> {
            String name = nameTxt.getText();
            String occupation = occupationTxt.getText();
            AgeCategory age = ageLst.getSelectedValue();
            Object empCbxSelectedItem = empCbo.getSelectedItem();
            String emp = (empCbxSelectedItem instanceof String) ? (String) empCbxSelectedItem : "";
            boolean cndCitizen = cndCitizenChk.isSelected();
            String taxID = taxTxt.getText();
            Gender gender = genderOptionGroup.getSelected();
            notifyFormEventListeners(new FormEvent(this, name, occupation, age, emp, cndCitizen, taxID, gender));
        });

    }

    private void setupAgeLst() {
        DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
        ageModel.addElement(AgeCategory.UNDER18);
        ageModel.addElement(AgeCategory.BETWEEN18AND65);
        ageModel.addElement(AgeCategory.OVER65);

        ageLst.setModel(ageModel);
        ageLst.setSelectedIndex(1);
        double lineHeight = nameTxt.getPreferredSize().getHeight();
        int ageListPreferredHeight = (int) Math.round(lineHeight * 3.2);
        int ageListPreferredWidth = (int) nameTxt.getPreferredSize().getWidth();
        Dimension ageListPreferredSize = new Dimension(ageListPreferredWidth, ageListPreferredHeight);
        ageLst.setPreferredSize(ageListPreferredSize);
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
        add(nameLbl, gc);

        //Row 1 Column 2
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = defaultCellInset;
        add(nameTxt, gc);

        //Row 2 Column 1
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = labelCellInset;
        add(occupationLbl, gc);

        //Row 2 Column 2
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = defaultCellInset;
        add(occupationTxt, gc);

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
        add(ageLst, gc);

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
        add(empCbo, gc);

        //Row 5 Column 1
        gc.gridy = 4;
        gc.gridx = 0;
        gc.insets = labelCellInset;
        gc.anchor = GridBagConstraints.LINE_END;
        add(cndCitizenLbl, gc);

        //Row 5 Column 2
        gc.gridx = 1;
        gc.insets = defaultCellInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(cndCitizenChk, gc);

        //Row 6 Column 1
        gc.gridy = 5;
        gc.gridx = 0;
        gc.insets = labelCellInset;
        gc.anchor = GridBagConstraints.LINE_END;
        add(taxLbl, gc);

        //Row 6 Column 2
        gc.gridx = 1;
        gc.insets = defaultCellInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(taxTxt, gc);

        //Row 7 Column 1
        gc.gridy = 6;
        gc.gridx = 0;
        gc.insets = labelCellInset;
        gc.anchor = GridBagConstraints.LINE_END;
        add(genderLbl, gc);

        //Row 7 Column 2
        gc.gridx = 1;
        gc.insets = defaultCellInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(genderOptionGroup, gc);

        //Row 8 column 2
        gc.gridy = 7;
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
