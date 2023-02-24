package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class EnumButtonGroup<T extends OptionGroupEnum> extends JPanel {
    public static final int VERTICAL_GROUP = 0;
    public static final int HORIZONTAL_GROUP = 1;

    private final int orientationFlag;
    private final LinkedList<JRadioButton> optionBtns = new LinkedList<>();
    private final Class<? extends OptionGroupEnum> optionGroupEnum;
    private final List<OptionGroupEnum> enumItems;
    private final ButtonGroup buttonGroup;
    private final T defaultSelection;

    EnumButtonGroup(T defaultSelection, int orientationFlag) {
        this.defaultSelection = defaultSelection;
        this.orientationFlag = orientationFlag;
        this.optionGroupEnum = defaultSelection.getClass();

        int axis = (orientationFlag == VERTICAL_GROUP) ? BoxLayout.Y_AXIS : BoxLayout.X_AXIS;

        BoxLayout boxLayout = new BoxLayout(this,axis);
        setLayout(boxLayout);

        buttonGroup = new ButtonGroup();
        enumItems = Arrays.asList(optionGroupEnum.getEnumConstants());

        for (OptionGroupEnum value : enumItems) {
            JRadioButton optionBtn = new JRadioButton(value.getText());
            optionBtn.setActionCommand(value.toString());
            optionBtns.add(optionBtn);
            buttonGroup.add(optionBtn);
            if (defaultSelection == value) {
                optionBtn.setSelected(true);
            }
            add(optionBtn);
        }


    }

    public T getSelected() {
        ButtonModel selectedButtonModel = buttonGroup.getSelection();
        return (T) defaultSelection.getValueOf(selectedButtonModel.getActionCommand());
    }
}
