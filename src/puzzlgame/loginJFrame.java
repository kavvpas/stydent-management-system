package puzzlgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginJFrame extends JFrame {

    public loginJFrame() {
        // 1. Basic settings for the window
        // 窗口的基础设置
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 等同于写 3
        this.setTitle("Puzzle Game - Login");
        this.setLayout(null); // CRITICAL: Disable layout manager for absolute positioning (绝对定位必须取消默认布局)

        // 2. Create and add Username Label and Text Field
        // 创建并添加“用户名”文本提示和输入框
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 80, 30);
        this.getContentPane().add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(140, 100, 200, 30);
        this.getContentPane().add(usernameField);

        // 3. Create and add Password Label and Password Field
        // 创建并添加“密码”文本提示和密码输入框（输入时自动变黑点）
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 80, 30);
        this.getContentPane().add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(); // Special component for passwords
        passwordField.setBounds(140, 150, 200, 30);
        this.getContentPane().add(passwordField);

        // 4. Create the Login Button and inject the jump logic
        // 创建登录按钮，并注入咱们聊过的核心跳转逻辑
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 220, 90, 35);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get text from input fields
                // 获取用户在输入框里敲的内容
                String inputUser = usernameField.getText();
                // For JPasswordField, getText() is deprecated but totally fine for basic practice
                // 密码框获取内容（基础练习用这个最直观）
                String inputPass = new String(passwordField.getPassword());

                // Simulated verification (Simulate database check)
                // 模拟账号密码校验（假设正确的账号是 admin，密码是 123）
                if ("admin".equals(inputUser) && "123".equals(inputPass)) {
                    System.out.println("Login Successful! Launching game... (登录成功，启动游戏！)");

                    // Open the game window (开启游戏大门)
                    new gameJFrame();

                    // Close the current login window using OuterClass.this.dispose()
                    // 使用限定性 this 完美关闭、销毁当前的登录页面
                    loginJFrame.this.dispose();
                } else {
                    System.out.println("Login Failed! Invalid credentials. (账号或密码错误，登录失败！)");
                    // Pop up a warning dialog (弹出一个高大上的警告提示框)
                    JOptionPane.showMessageDialog(loginJFrame.this, "Wrong username or password! (账号或密码错误！)");
                }
            }
        });
        this.getContentPane().add(loginButton);

        // 5. Menu Bar setup (Kept from your original code)
        // 菜单栏设置（保留你之前写的菜单骨架）
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
        this.setJMenuBar(jMenuBar);

        // Make it visible at the very end
        // 所有组件装配完毕，最后一步：亮相！
        this.setVisible(true);
    }
}