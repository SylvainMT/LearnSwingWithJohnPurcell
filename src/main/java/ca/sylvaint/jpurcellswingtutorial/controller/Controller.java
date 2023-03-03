package ca.sylvaint.jpurcellswingtutorial.controller;

import ca.sylvaint.jpurcellswingtutorial.gui.FormEvent;
import ca.sylvaint.jpurcellswingtutorial.model.*;

import java.io.File;
import java.util.List;

public class Controller {
    private Database db = new Database();
    public List<Person> getPeople() {
        return db.getPeople();
    }

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

    public void saveToFile(File file) {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) {
        db.loadFromFile(file);
    }
}
