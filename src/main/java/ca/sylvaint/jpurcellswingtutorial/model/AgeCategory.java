package ca.sylvaint.jpurcellswingtutorial.model;

public enum AgeCategory {
    UNDER18(0, "Under 18"),
    BETWEEN18AND65(1, "18 to 65"),
    OVER65(2, "Over 65");

    private final int id;
    private final String text;

    AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
}
