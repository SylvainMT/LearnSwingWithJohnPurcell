package ca.sylvaint.jpurcellswingtutorial.model;

public enum EmploymentCategory {
    Employed("Employed", 0),
    SelfEmployed("Self-Employed", 1),
    Unemployed("Unemployed", 2),
    Other("Other", 3);

    private String text;
    private int id;

    EmploymentCategory(String text, int id) {
        this.text = text;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.text;
    }

    public int getId() {
        return id;
    }
}
