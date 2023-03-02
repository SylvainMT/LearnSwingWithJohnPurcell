package ca.sylvaint.jpurcellswingtutorial.model;

public interface OptionGroupEnum<T> {
    String getText();
    int getId();

    T getValueOf(String string);

}
