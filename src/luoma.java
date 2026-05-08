import java.util.Scanner;

public class luoma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter number:");
        int[] num = new int[8];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        StringBuilder luo = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            luo.append(zhuanhuan(num[i]));
        }
        System.out.println("转换结果为: " + luo.toString());
    }
    public static String zhuanhuan(int num){
        Scanner sc = new Scanner(System.in);
        String[] LM = {"","yi","er","san","si","wu","liu","qi","ba","jiu"};
        if (num < 0 || num > 9) {
            return "[错误]";
        }
        return LM[num];
    }
}
