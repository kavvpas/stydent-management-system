public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // --- 1. 变量与基本数据类型 ---
        int age = 25;
        double salary = 250000.50; // 日本求职常看的月薪（double精度高）
        char grade = 'A';
        boolean isITJobFound = false;

        // --- 2. 算术运算符与“自增自减” (重点！) ---
        int a = 10;
        int b = a++; // 后自增：先赋值给b，a再加1 -> b=10, a=11
        int c = ++a; // 前自增：a先加1，再赋值给c -> a=12, c=12
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);

        // --- 3. 赋值与关系运算符 ---
        a += 5; // 等同于 a = a + 5
        boolean compare = (a >= 15) && (age < 30); // 逻辑与：两个都对才是true

        // --- 4. 三元运算符 (面试爱考，替代简单if-else) ---
        String status = isITJobFound ? "在东京上班" : "在语言学校努力";
        System.out.println("当前状态: " + status);

        // --- 5. 数据类型转换 (隐式 vs 强制) ---
        int num = 100;
        double numDouble = num; // 隐式转换：小转大，自动转
        int numInt = (int) salary; // 强制转换：大转小，会丢失小数位

        // --- 6. 流程控制之 Switch (黑马视频里常用来做选择菜单) ---
        int month = 4;
        switch (month) {
            case 4:
                System.out.println("4月生入学/TOEIC考试月");
                break; // 别忘了break，否则会发生“case穿透”
            default:
                System.out.println("其他月份继续加油");
        }
    }
    }
