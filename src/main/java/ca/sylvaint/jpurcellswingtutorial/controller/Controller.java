package ca.sylvaint.jpurcellswingtutorial.controller;

import ca.sylvaint.jpurcellswingtutorial.gui.FormEvent;
import ca.sylvaint.jpurcellswingtutorial.model.*;

public class Controller {
    private Database db = new Database();

    public void addPerson(FormEvent fe) {
        String name = fe.getName();
        String occupation = fe.getOccupation();
        AgeCategory ageCat = fe.getAgeCategory();
        EmploymentCategory empCat = fe.getEmpCategory();
        String empCatOther = fe.getEmpCategoryOther();
        boolean cndCitizen = fe.isCndCitizen();
        String taxId = fe.getTaxID();
        Gender gender = fe.getGender();


        Person person = new Person(name, occupation, ageCat, empCat, empCatOther, cndCitizen, taxId, gender);
        db.addPerson(person);
    }
}
