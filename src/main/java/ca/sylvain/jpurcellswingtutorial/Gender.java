package ca.sylvain.jpurcellswingtutorial;

public enum Gender implements OptionGroupEnum  {
    MALE("Male", 0),
    FEMALE("Female", 1);

    private String text;
    private int id;

    Gender(String text, int id) {
        this.text = text;
        this.id = id;
    }

    @Override
    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    @Override
    public Gender getValueOf(String string) {
        return valueOf(string);
    }


}
