package deepClone;

import java.util.ArrayList;

public class ApiTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        // 1. Set up a prototype bike in Nerima, Tokyo
        // 初始化原型车：在练马区，状态为待骑行
        GPS baseGPS = new GPS("35.72, 139.65 (Nerima)");
        Bike prototypeBike = new Bike("BIKE-001", baseGPS);

        ArrayList<Bike> shallowFleet = new ArrayList<>();
        ArrayList<Bike> deepFleet = new ArrayList<>();

        // 2. Build fleets via cloning
        // 批量复制出车队
        for (int i = 0; i < 3; i++) {
            shallowFleet.add(prototypeBike.shallowClone());
            deepFleet.add(prototypeBike.deepClone());
        }

        System.out.println("============== SYSTEM MONITOR OVERVIEW ==============");

        // =======================================================
        // CRISIS: Shallow clone shared memory failure
        // 模拟危机：浅克隆一损俱损 —— 1号车遇到黑客，全城车辆状态一起坏掉
        // =======================================================
        System.out.println("\n[CRITICAL] Shallow-Bike 0 hits an error! Dispatching to HACKED status...");
        shallowFleet.get(0).dispatch("SYSTEM_ERROR!", Status.MAINTENANCE);

        System.out.println("\n--- Shallow Fleet Control Panel (浅克隆监控盘) ---");
        for (Bike b : shallowFleet) {
            System.out.println(b.getBikeLog());
        }
        // 😱 看控制台：因为浅克隆的致命伤，所有车的 GPS 全部变成了 SYSTEM_ERROR!


        // =======================================================
        // SUCCESS: Deep clone isolation work perfectly
        // 模拟成功：深克隆完美隔离 —— 0号车用户正常骑行去涩谷，其他车不受影响
        // =======================================================
        System.out.println("\n---------------------------------------------------------");
        System.out.println("[NORMAL] Deep-Bike 0 is scanned by user. Dispatching to Shibuya...");
        deepFleet.get(0).dispatch("35.65, 139.70 (Shibuya)", Status.IN_USE);

        System.out.println("\n--- Deep Fleet Control Panel (深克隆监控盘) ---");
        for (Bike b : deepFleet) {
            System.out.println(b.getBikeLog());
        }
        // 😎 看控制台：只有 0 号车变成了 IN_USE 和 Shibuya，其他车依然静静躺在练马区（AVAILABLE）！
    }
}