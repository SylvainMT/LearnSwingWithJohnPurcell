package ca.sylvaint.jpurcellswingtutorial.gui;

import ca.sylvaint.jpurcellswingtutorial.model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel tableModel;
    TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
