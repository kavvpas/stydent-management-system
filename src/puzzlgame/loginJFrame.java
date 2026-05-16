package puzzlgame;

import javax.swing.*;

public class loginJFrame extends JFrame {
    public loginJFrame(){
        this.setSize(500,500);
        setDefaultCloseOperation(3);
        setTitle("puzzle game");
        JMenuBar jMenuBar = new JMenuBar();

        JMenu function = new JMenu("function");
        JMenu about = new JMenu("about us");

        JMenuItem replay = new JMenuItem("replay");
        JMenuItem register = new JMenuItem("register");
        JMenuItem closure = new JMenuItem("closure");

        JMenuItem account = new JMenuItem("official account");

        function.add(replay);
        function.add(register);
        function.add(closure);
        about.add(account);

        jMenuBar.add(function);
        jMenuBar.add(about);

        setJMenuBar(jMenuBar);

        this.setVisible(true);
    }

}
