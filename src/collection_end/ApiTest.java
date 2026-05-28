package collection_end;


import java.util.*;

// 1. 自定义单车域模型：复习重写 equals & hashCode
class Bike {
    String bikeId; // 单车唯一编号
    int battery;   // 电量

    public Bike(String bikeId, int battery) {
        this.bikeId = bikeId;
        this.battery = battery;
    }

    // 🌟 核心防线：只要单车编号（bikeId）一样，就认为是同一台车，HashSet 靠它全自动去重
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(bikeId, bike.bikeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeId);
    }

    @Override
    public String toString() {
        return "[" + bikeId + "(电量:" + battery + "%)]";
    }
}

public class ApiTest {
    public static void main(String[] args) {
        System.out.println("========= 🚲 东京 Next-Bike 智能集合调度系统 3.0 =========\n");

        // =================================================================
        // 战场一：HashSet 去重兵团 🛡️
        // =================================================================
        System.out.println("--- 🛰️ 正在从物联网传感器接收原始 GPS 报文 (测试 HashSet 去重) ---");
        HashSet<Bike> rawBikesSet = new HashSet<>();

        rawBikesSet.add(new Bike("BK-001", 90));
        rawBikesSet.add(new Bike("BK-002", 45));
        rawBikesSet.add(new Bike("BK-001", 15)); // 👈 故意录入重复的 BK-001（电量不同）

        // 此时由于 equals & hashCode 的保护，第二个 BK-001 会被无情弹飞
        System.out.print("【去重结果】实际合法上线单车清单: ");
        rawBikesSet.forEach(bike -> System.out.print(bike + " "));
        System.out.println("\n");


        // =================================================================
        // 战场二：ArrayList 动态调度兵团 🏃
        // =================================================================
        System.out.println("--- 📦 正在将合法单车装载入集装箱 (测试 ArrayList 动态扩容与索引) ---");
        ArrayList<Bike> activeBikesList = new ArrayList<>(rawBikesSet); // 直接把 Set 里的安全数据甩进 List

        // 随便用索引 get 一个单车看看
        System.out.println("【索引查询】当前单车队列中，处于领头位置的单车是: " + activeBikesList.get(0));
        System.out.println();


        // =================================================================
        // 战场三：HashMap 套娃大衣架 🏮（One Key to Many Values）
        // =================================================================
        System.out.println("--- 🗺️ 正在建立东京多维区域网格化调度地图 (测试 Map 套娃 List) ---");
        HashMap<String, ArrayList<Bike>> zoneMap = new HashMap<>();

        // 利用我们刚学过的 computeIfAbsent 终极两行流，把单车塞进对应的“网格区域”
        // 练马区塞入第一辆车
        zoneMap.computeIfAbsent("练马区", k -> new ArrayList<>()).add(activeBikesList.get(0));
        // 练马区追加第二辆车
        zoneMap.computeIfAbsent("练马区", k -> new ArrayList<>()).add(new Bike("BK-003", 80));
        // 新宿区开辟新网格
        zoneMap.computeIfAbsent("新宿区", k -> new ArrayList<>()).add(activeBikesList.get(1));

        // 闪电打印多维网格地图
        zoneMap.forEach((zone, bikeList) -> {
            System.out.println("⚓ 网格 [" + zone + "] -> 当前驻扎机队: " + bikeList);
        });
        System.out.println();


        // =================================================================
        // 战场四：TreeMap 红黑树军团 🌳（自动排序的天花板）
        // =================================================================
        System.out.println("--- 📊 正在启动后台清算中心·低电量故障率自动排序报表 (测试 TreeMap) ---");

        // Key 存电量（Integer，它天生自带比大小能力），Value 存单车编号（String）
        // TreeMap 会根据 Key（电量）自动升序排列，谁电量低谁排在最前面！
        TreeMap<Integer, String> lowBatteryReport = new TreeMap<>();

        // 抓出所有单车，把它们的电量作为 Key 塞进 TreeMap
        activeBikesList.add(new Bike("BK-003", 80)); // 再加一台高电量的凑数

        activeBikesList.forEach(bike -> lowBatteryReport.put(bike.battery, bike.bikeId));

        System.out.println("🚨 【红黑树自动排序】请调度员优先充电（电量从低到高自动倒叙排好了）：");
        lowBatteryReport.forEach((battery, id) -> {
            System.out.println("   • 单车 ID: " + id + " | 🔋 当前剩余电量: " + battery + "% (需注意！)");
        });

        System.out.println("\n=========================================================");
        System.out.println("🏮 恭喜兄弟！全场集合进阶技术对线完毕，全部安全编译通过！ Lantern off! 下班！");
    }
}
