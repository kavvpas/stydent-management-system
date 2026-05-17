package puzzlgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerJFrame extends JFrame  {
    public registerJFrame(){
        this.setSize(500,500);
        JButton jtb1 = new JButton();
        jtb1.setBounds(0,0,35,20);
        jtb1.setName("register");
        jtb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        this.setVisible(true);
    }
}
