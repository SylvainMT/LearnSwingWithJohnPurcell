package ca.sylvain.jpurcellswingtutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Toolbar extends JPanel implements ActionListener {
    private JButton helloBtn;
    private JButton goodByeBtn;
    private StringListener  textListener;

    Toolbar() {
        helloBtn = new JButton("Hello");
        helloBtn.addActionListener(this);
        goodByeBtn = new JButton("Goodbye");
        goodByeBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        setBorder(BorderFactory.createEtchedBorder());

        add(helloBtn);
        add(goodByeBtn);
    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (textListener == null) {
            return;
        }
        JButton clicked = (JButton) ae.getSource();

        if (clicked == helloBtn) {
            textListener.textEmitted("Hello\n");
        } else  if(clicked == goodByeBtn){
            textListener.textEmitted("Goodbye\n");
        }
    }
}
