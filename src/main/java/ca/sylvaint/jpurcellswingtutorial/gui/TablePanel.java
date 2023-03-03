package ca.sylvaint.jpurcellswingtutorial.gui;

import ca.sylvaint.jpurcellswingtutorial.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popupMenu;
    TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        popupMenu = new JPopupMenu();

        JMenuItem deleteRowItem = new JMenuItem("Delete Row");
        popupMenu.add(deleteRowItem);

        table.addMouseListener(new TableMouseListener());

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    class TableMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                int x = e.getX();
                int y = e.getY();

                popupMenu.show(table, x, y);
            }
        }
    }
}
