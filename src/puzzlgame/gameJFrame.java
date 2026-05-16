package puzzlgame;

import javax.swing.*;
import java.util.Random;

public class gameJFrame extends JFrame {
    int[][] data = new int[2][3];
    public gameJFrame(){
        initJMenuBar();

        intidate();

        initImage();


        this.setVisible(true);
    }
    private void initImage(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <3; j++) {
                int number = data[i][j];
                JLabel jLabel1 = new JLabel(new ImageIcon("C:\\Users\\17333\\Pictures\\sp\\" + number + ".jpg"));
                jLabel1.setBounds(66 * j, 66 * i, 66, 66);
                this.getContentPane().add(jLabel1);
            }
        }

    }
    private void intidate(){
        int[] a = {0,1,2,3,4,5};
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int index = r.nextInt(a.length);
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        for (int i = 0; i < 6; i++) {
            data[i / 2][i % 3] = a[i];
        }
    }
    private void initJMenuBar(){
        this.setSize(650,800);
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

        setLayout(null);

        setJMenuBar(jMenuBar);
    }

}
