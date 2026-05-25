import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringJoiner;

public class Apitest {
    public static void main(String[] args) {
        System.out.println("============== 🏮 居酒屋桌况账单系统 2.0 🏮 ==============");

        // 1. 创建 HashMap：Key 是桌号(String)，Value 是当前桌的消费金额(Integer)
        HashMap<String, Integer> barMap = new HashMap<>();

        // 2. 存入数据 (put)：模拟客人落座并点单
        barMap.put("1号包厢", 15800);
        barMap.put("3号靠窗", 8500);
        barMap.put("吧台A座", 3200);
        barMap.put("吧台B座", 4500);

        // 3. 模拟业务修改：吧台A座的客人加点了一杯生啤，账单追加 600 円
        // HashMap 的特点：Key 若重复，后面的 Value 会直接覆盖老数据
        barMap.put("吧台A座", 3200 + 600);

        // 4. 精准查询 (get)：前台结账，光速查出 1号包厢 的消费金额
        String targetTable = "1号包厢";
        if (barMap.containsKey(targetTable)) { // 先安全检查是否存在这个键
            Integer money = barMap.get(targetTable);
            System.out.println("🔔 前台通知：" + targetTable + " 正在结账，消费总额为: " + money + " 円");
        }

        System.out.println("\n--- 🗺️ 正在使用 Java 8 Lambda 闪电遍历全场桌况 ---");

        // 5. 现代化遍历：利用 Map 的 forEach 配合 Lambda 表达式，一行把所有键值对打印出来
        // 括号里的 (table, price) 分别代表每次循环抓出来的 Key 和 Value
        barMap.forEach((table, price) -> {
            System.out.println("⚓ 状态 [已落座] -> " + table + " | 当前流水: " + price + " 円");
        });

        System.out.println("=======================================================");
    }
}