package puzzlgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerJFrame extends JFrame {

    public registerJFrame(){
        // 1. Basic settings for the register window
        // 注册窗口的基本设置
        this.setSize(500,500);
        this.setTitle("Register");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); // CRITICAL: Disable default layout for setBounds to work (必须取消默认布局)

        // 2. Create the register button
        // 创建注册按钮
        JButton jtb1 = new JButton();
        jtb1.setBounds(50, 50, 100, 40); // Adjusted size so text is visible (稍微改大了一点，不然字装不下)
        jtb1.setText("Register"); // FIXED: Use setText instead of setName (按钮显示的文字用setText)

        // 3. Add listener for window transition
        // 给按钮绑定事件，实现页面跳转
        jtb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register successful. Transitioning... (注册成功，开始跳转)");

                // Open the game window (打开游戏新窗口)
                new gameJFrame();

                // FIXED: Close the current register window!
                // 关键修复：关闭当前的注册窗口！
                // outer class reference inside anonymous class (在匿名内部类里调用外部类的dispose)
                registerJFrame.this.dispose();
            }
        });

        // 4. Put the button onto the screen and make it visible
        // 把按钮装进窗口，并显示出来
        this.getContentPane().add(jtb1);
        this.setVisible(true);
    }
}