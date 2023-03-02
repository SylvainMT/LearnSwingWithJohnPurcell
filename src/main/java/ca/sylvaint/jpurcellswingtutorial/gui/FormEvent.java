package ca.sylvaint.jpurcellswingtutorial.gui;

import ca.sylvaint.jpurcellswingtutorial.model.AgeCategory;
import ca.sylvaint.jpurcellswingtutorial.model.Gender;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private final String name;
    private final String occupation;
    private final AgeCategory ageCategory;
    private final String empCategory;
    private final boolean cndCitizen;
    private final String taxID;
    private final Gender gender;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source,
                     String name,
                     String occupation,
                     AgeCategory ageCategory,
                     String empCategory,
                     boolean cndCitizen,
                     String taxID,
                     Gender gender) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.cndCitizen = cndCitizen;
        this.taxID = taxID;
        this.gender = gender;
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

    public String getEmpCategory() {
        return empCategory;
    }

    public boolean isCndCitizen() {
        return cndCitizen;
    }

    public String getTaxID() {
        return taxID;
    }

    public Gender getGender() {
        return gender;
    }
}
