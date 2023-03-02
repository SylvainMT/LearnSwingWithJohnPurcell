package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.TooManyListenersException;

class MainFrame extends JFrame {
    private final TextPanel textPanel;
    private final Toolbar toolbar;
    private final FormPanel formPanel;
    MainFrame () {
        super("Hello World");

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        toolbar.setStringListener(textPanel::appendText);
        try {
            formPanel.addFormEventListener((FormEvent fe) -> {
                String text = fe.getName() +
                        " : " +
                        fe.getOccupation() +
                        " : " +
                        fe.getAgeCategory().getId() +
                        " : " +
                        fe.getEmpCategory() +
                        " : " +
                        fe.isCndCitizen() +
                        " : " +
                        fe.getTaxID() +
                        " : " +
                        fe.getGender().getText() +
                        "\n";
                textPanel.appendText(text);
            });
        } catch (TooManyListenersException e) {
            throw new RuntimeException(e);
        }


        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        windowMenu.add(showMenu);
        showMenu.add(showFormItem);


        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        showFormItem.addActionListener((ActionEvent ae) -> {
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ae.getSource();
            formPanel.setVisible(menuItem.isSelected());
        });

        return menuBar;
    }
}
