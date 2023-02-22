package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Toolbar extends JPanel implements ActionListener {
    private JButton helloBtn;
    private JButton goodByeBtn;
    private TextPanel textPanel;
    Toolbar() {
        helloBtn = new JButton("Hello");
        helloBtn.addActionListener(this);
        goodByeBtn = new JButton("Goodbye");
        goodByeBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloBtn);
        add(goodByeBtn);
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton clicked = (JButton) ae.getSource();

        if (clicked == helloBtn) {
            textPanel.appendText("Hello\n");
        } else  if(clicked == goodByeBtn){
            textPanel.appendText("Goodbye\n");
        }
    }
}
