package ca.sylvain.jpurcellswingtutorial.gui;

import ca.sylvaint.jpurcellswingtutorial.model.OptionGroupEnum;

import javax.swing.*;

class EnumButtonGroup<T extends OptionGroupEnum<T>> extends JPanel {
    public static final int VERTICAL_GROUP = 0;
    public static final int HORIZONTAL_GROUP = 1;
    private final ButtonGroup buttonGroup;
    private final T defaultSelection;

    EnumButtonGroup(T defaultSelection, int orientationFlag) {
        if (defaultSelection == null) {
            throw new NullPointerException();
        }

        this.defaultSelection = defaultSelection;

        int axis = (orientationFlag == VERTICAL_GROUP) ? BoxLayout.Y_AXIS : BoxLayout.X_AXIS;

        BoxLayout boxLayout = new BoxLayout(this, axis);
        setLayout(boxLayout);

        buttonGroup = new ButtonGroup();

        //Because we are dealing with Generics, it is impossible for the compiler to check the casting of this, so we suppress the warning.
        @SuppressWarnings("unchecked")
        T[] enumItems = (T[]) defaultSelection.getClass().getEnumConstants();

        for (T value : enumItems) {
            JRadioButton optionBtn = new JRadioButton(value.getText());
            optionBtn.setActionCommand(value.toString());
            buttonGroup.add(optionBtn);
            if (defaultSelection == value) {
                optionBtn.setSelected(true);
            }
            add(optionBtn);
        }
    }

    public T getSelected() {
        ButtonModel selectedButtonModel = buttonGroup.getSelection();
        return defaultSelection.getValueOf(selectedButtonModel.getActionCommand());
    }
}
