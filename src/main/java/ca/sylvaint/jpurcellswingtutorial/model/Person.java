package ca.sylvaint.jpurcellswingtutorial.model;

public class Person {

    public static int personAutoIncrementValue = 0;

    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory empCategory;
    private boolean cndCitizen;
    private String taxID;
    private Gender gender;

    public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory empCategory, boolean cndCitizen, String taxID, Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.cndCitizen = cndCitizen;
        this.taxID = taxID;
        this.gender = gender;

        this.id = personAutoIncrementValue;
        personAutoIncrementValue++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(EmploymentCategory empCategory) {
        this.empCategory = empCategory;
    }

    public boolean isCndCitizen() {
        return cndCitizen;
    }

    public void setCndCitizen(boolean cndCitizen) {
        this.cndCitizen = cndCitizen;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
