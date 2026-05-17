package puzzlgame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gameJFrame extends JFrame implements KeyListener {
    int[][] data = new int[3][3];
    int speaceX = 0;
    int speaceY = 0;
    public gameJFrame(){
        initJMenuBar();

        intidate();

        initImage();


        this.setVisible(true);
    }
    private void initImage(){
        this.getContentPane().removeAll();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                int number = data[i][j];
                JLabel jLabel1 = new JLabel(new ImageIcon("C:\\Users\\17333\\Pictures\\sp\\" + number + ".jpg"));
                jLabel1.setBounds(66 * j, 66 * i, 66, 66);
                this.getContentPane().add(jLabel1);
                this.getContentPane().repaint();
            }
        }

    }
    private void intidate(){
        int[] a = {0,1,2,3,4,5,6,7,8};
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            int index = r.nextInt(a.length);
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        for (int i = 0; i < 9; i++) {
            if (a[i] == 0){
                speaceX = i / 3;
                speaceY = i % 3;
            }else {
                data[i / 3][i % 3] = a[i];
            }
        }
    }
    private void initJMenuBar(){
        this.setSize(350,400);
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

        this.addKeyListener(this);

        setJMenuBar(jMenuBar);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case 37: // Left Arrow Key (左方向键)
                if (speaceY != 0) {
                    System.out.println("Move Left (向左移动)");
                    int temp = data[speaceX][speaceY];
                    data[speaceX][speaceY] = data[speaceX][speaceY - 1];
                    data[speaceX][speaceY - 1] = temp;

                    // CRITICAL: Update the blank block's coordinate!
                    // 关键点：更新空白块的列坐标！
                    speaceY--;
                } else {
                    System.out.println("Left move hit boundary. (左边撞墙了)");
                }
                break; // Prevent falling through (防止穿透)

            case 38: // Up Arrow Key (上方向键)
                if (speaceX != 0) {
                    System.out.println("Move Up (向上移动)");
                    int temp2 = data[speaceX][speaceY];
                    data[speaceX][speaceY] = data[speaceX - 1][speaceY];
                    data[speaceX - 1][speaceY] = temp2;

                    // Update row coordinate
                    // 更新空白块的行坐标！
                    speaceX--;
                } else {
                    System.out.println("Up move hit boundary. (上边撞墙了)");
                }
                break;

            case 39: // Right Arrow Key (右方向键)
                // FIXED BOUNDARY: Max index is 2 for length 3
                // 修复边界：3x3矩阵最大索引是2
                if (speaceY != 2) {
                    System.out.println("Move Right (向右移动)");
                    int temp3 = data[speaceX][speaceY];
                    data[speaceX][speaceY] = data[speaceX][speaceY + 1];
                    data[speaceX][speaceY + 1] = temp3;

                    speaceY++; // Blank block moves right (空白块右移)
                } else {
                    System.out.println("Right move hit boundary. (右边撞墙了)");
                }
                break;

            case 40: // Down Arrow Key (下方向键)
                if (speaceX != 2) {
                    System.out.println("Move Down (向下移动)");
                    int temp4 = data[speaceX][speaceY];
                    data[speaceX][speaceY] = data[speaceX + 1][speaceY];
                    data[speaceX + 1][speaceY] = temp4;

                    speaceX++; // Blank block moves down (空白块下移)
                } else {
                    System.out.println("Down move hit boundary. (下边撞墙了)");
                }
                break;
        }

        // RE-DRAW: Refresh the user interface to show changes!
        // 重新绘制：移动完数据后，必须调用它重新加载图片，界面才会刷新！
        initImage();
    }
}
