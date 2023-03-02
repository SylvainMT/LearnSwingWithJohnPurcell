package ca.sylvaint.jpurcellswingtutorial.gui;

import ca.sylvaint.jpurcellswingtutorial.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class PersonTableModel extends AbstractTableModel {

    private List<Person> db;

    public void setData(List<Person> db) {
        this.db = db;
    }
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = db.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> person.getId();
            case 1 -> person.getName();
            case 2 -> person.getOccupation();
            case 3 -> person.getAgeCategory();
            case 4 -> person.getEmpCategory();
            case 5 -> person.isCndCitizen();
            case 6 -> person.getTaxID();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Name";
            case 2 -> "Occupation";
            case 3 -> "Age Category";
            case 4 -> "Employment Status";
            case 5 -> "Is a Canadian Citizen";
            case 6 -> "Tax ID";
            default -> "";
        };
    }
}
