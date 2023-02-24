package ca.sylvain.jpurcellswingtutorial;

public interface OptionGroupEnum<T> {
    String getText();
    int getId();

    T getValueOf(String string);

}
