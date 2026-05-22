package deepClone;

import java.util.ArrayList;

public class ApiTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        GPS baseGPS = new GPS("35.72, 139.65 (Nerima)");

        // Create 5 different deep cloned bikes to simulate a real town
        // 深克隆 5 台独立的单车，模拟真实的练马区街头
        ArrayList<Bike> townFleet = new ArrayList<>();
        townFleet.add(new Bike("BIKE-001", baseGPS).deepClone());
        townFleet.add(new Bike("BIKE-002", baseGPS).deepClone());
        townFleet.add(new Bike("BIKE-003", baseGPS).deepClone());
        townFleet.add(new Bike("BIKE-004", baseGPS).deepClone());
        townFleet.add(new Bike("BIKE-005", baseGPS).deepClone());

        // Simulate daily operations (模拟日常运营：用户骑行、车辆坏掉)
        townFleet.get(0).dispatch("35.65, 139.70 (Shibuya)", Status.IN_USE);
        townFleet.get(1).dispatch("35.69, 139.70 (Shinjuku)", Status.IN_USE);
        townFleet.get(2).dispatch("BROKEN_CHAIN", Status.MAINTENANCE);

        System.out.println("============== REAL-TIME MONITORING (全城监控现状) ==============");
        for (Bike b : townFleet) {
            System.out.println(b.getBikeLog());
        }

        // =======================================================
        // 🌟 NEW ADDED FEATURE: FLEET ANALYTICS DASHBOARD
        // 🌟 核心新功能：后台数据分析看板（利用集合遍历与枚举比对）
        // =======================================================
        System.out.println("\n============== ANALYTICS DASHBOARD (运营数据看板) ==============");

        int inUseCount = 0;
        int availableCount = 0;
        int maintenanceCount = 0;

        // Loop through the entire fleet to aggregate data
        // 遍历全城车队，进行分类数量统计
        for (int i = 0; i < townFleet.size(); i++) {
            Bike currentBike = townFleet.get(i);

            // Match enum constants (比对枚举状态)
            if (currentBike.getStatus() == Status.IN_USE) {
                inUseCount++;
            } else if (currentBike.getStatus() == Status.AVAILABLE) {
                availableCount++;
            } else if (currentBike.getStatus() == Status.MAINTENANCE) {
                maintenanceCount++;
            }
        }

        // Print final dashboard report (打印最终的运营报表)
        System.out.println("Total Registered Bikes (总在线车辆): " + townFleet.size() + " 台");
        System.out.println("🟢 Available for Users (待骑行数量): " + availableCount + " 台");
        System.out.println("🔵 Active Rides Right Now (骑行中数量): " + inUseCount + " 台");
        System.out.println("🔴 Under Repair Status (维修中数量): " + maintenanceCount + " 台");
        System.out.println("===============================================================");
    }
}new project