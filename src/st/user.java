package st;

import java.util.Scanner;

public class user {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] str = new String[3][3];
        userMesserge[] stru = new userMesserge[3];
        for (int i = 0; i < str.length; i++) {
            // --- 第一步：用 while 循环死磕“名字” ---
            String name;
            while (true) {
                System.out.println("请输入第 " + (i + 1) + " 个学生的名字:");
                name = sc.next();

                // 调用你搬家到 userMesserge 里的 check 方法
                if (userMesserge.check(stru, name)) {
                    System.out.println("❌ 名字 [" + name + "] 已存在，请换一个名字重新输入！");
                    // 注意：这里没有 break，所以会回到 while 开头让用户重新输入
                } else {
                    // 名字没重复，存入数组并跳出这个 while 循环
                    str[i][0] = name;
                    break;
                }
            }

            // --- 第二步：名字录对了，再录剩下的信息 ---
            System.out.println("请输入年龄:");
            str[i][1] = sc.next();
            System.out.println("请输入编号:");
            str[i][2] = sc.next();

            // --- 第三步：封装入柜 ---
            stru[i] = new userMesserge(str[i][0], str[i][1], str[i][2]);
            System.out.println("✅ 录入成功！");
        }
        System.out.println("please enter num:");
        String deleteNum = sc.next();
        for (int i = 0; i < stru.length; i++) {
            if (stru[i].getNumber().equals(deleteNum)){
                stru[i].setName("deleted");
                stru[i].setAge("deleted");
                stru[i].setNumber("deleted");
                break;
            }else {
                System.out.println("deletion failed");
            }
        }

        for (int i = 0; i < str.length; i++) {

                System.out.printf("the students messenger: " + str[i][0] + "  "+ str[i][1] + "  "+ str[i][2]);

            System.out.println();
        }
        System.out.println(stru[2].getName());
    }

}
