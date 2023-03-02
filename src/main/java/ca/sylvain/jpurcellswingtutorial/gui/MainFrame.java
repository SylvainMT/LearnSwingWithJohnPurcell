package ca.sylvain.jpurcellswingtutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.TooManyListenersException;

class MainFrame extends JFrame {
    private final TextPanel textPanel;
    private final Toolbar toolbar;
    private final FormPanel formPanel;
    private JFileChooser fileChooser;
    MainFrame () {
        super("Hello World");

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new PersonFileFilter());

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
        setMinimumSize(new Dimension(500, 400));
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

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        importDataItem.addActionListener((ActionEvent ae) -> {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile());
            }

        });

        exportDataItem.addActionListener((ActionEvent ae) -> {
            if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(fileChooser.getSelectedFile());
            }
        });

        exitItem.addActionListener((ActionEvent ae) -> {
            int action = JOptionPane.showConfirmDialog(MainFrame.this,
                    "Do you really want to exit the application?",
                    "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

            if (action == JOptionPane.OK_OPTION) {
                System.exit(0);
            }




        });

        return menuBar;
    }
}
