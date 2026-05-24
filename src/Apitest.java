import java.util.ArrayList;
import java.util.StringJoiner;

public class Apitest {
    public static void main(String[] args) {
        System.out.println("============== 🏮 东京居酒屋收银系统 1.0 🏮 ==============");

        // 1. 数组复习：记录今晚前 5 桌客人的账单金额 (单位：日元)
        int[] tableBills = {4500, 12000, 3200, 8500, 6000};

        // 2. 集合高级进阶：动态记录客人给的额外小费 (Tip Fleet)
        ArrayList<Integer> tipsList = new ArrayList<>();
        tipsList.add(500);
        tipsList.add(1000);
        tipsList.add(0); // 这桌没给
        tipsList.add(2000);
        tipsList.add(300);

        // 3. 核心业务计算：遍历数组统计总营业额
        int totalSales = 0;
        for (int i = 0; i < tableBills.length; i++) {
            totalSales += tableBills[i];
        }

        // 4. 集合遍历：统计今晚兼职斩获的总小费
        int totalTips = 0;
        for (int i = 0; i < tipsList.size(); i++) {
            totalTips += tipsList.get(i);
        }

        // 5. 串联新 API：使用 StringJoiner 优雅拼接深夜结算报表
        StringJoiner report = new StringJoiner(" \n ", "[ 居酒屋深夜结账单 ]\n", "");
        report.add("• 总接待桌数: " + tableBills.length + " 桌");
        report.add("• 纯料理营业额: " + totalSales + " 円");
        report.add("• 兼职小费收入: " + totalTips + " 円");
        report.add("• 今晚总流水账面: " + (totalSales + totalTips) + " 円");

        // 打印最终报表
        System.out.println(report.toString());
        System.out.println("=======================================================");
    }
}