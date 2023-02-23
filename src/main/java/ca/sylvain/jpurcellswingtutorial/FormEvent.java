package ca.sylvain.jpurcellswingtutorial;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private final String name;
    private final String occupation;

    private final AgeCategory ageCategory;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source, String name, String occupation, AgeCategory ageCategory) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }
}
