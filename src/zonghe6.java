import java.util.Random;
import java.util.Scanner;

public class zonghe6 {
    public static void main(String[] args) {
        System.out.println("please enter a number (up to 6 digits):");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Random r = new Random();
        if (num < 1000000 && num >= 0) {
            int falsenum = changeNum(num);
            System.out.println("The changed number is: " + falsenum);
        } else {
            System.out.println("Please enter a correct number (0-999999)");
        }
    }

    public static int changeNum(int num) {
        // 1. 修改：数组长度必须足够
        int[] arr = new int[6];
        int temp = num;

        // 2. 优化拆解逻辑：从个位开始拆，存入数组
        for (int i = 0; i < 6; i++) {
            int digit = temp % 10;      // 拿到最后一位
            arr[i] = (digit + 5) % 10;  // 模拟变换逻辑：加5并对10取余
            temp = temp / 10;           // 砍掉最后一位
        }

        // 3. 重组数字：把数组里的数字重新拼成一个 int
        int newnum = 0;
        int multiplier = 1; // 位权：1, 10, 100, 1000...

        for (int i = 0; i < arr.length; i++) {
            // 这里我们按原序还原（如果想反转，就改变遍历顺序）
            newnum += arr[i] * multiplier;
            multiplier *= 10;
        }

        return newnum;
    }
}