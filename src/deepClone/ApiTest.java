package deepClone;

import java.util.ArrayList;

public class ApiTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        // 1. Initialize prototype bike (初始化一台在练马区的原型单车)
        GPS normalGPS = new GPS("35.72, 139.65 (Nerima, Tokyo)");
        Bike prototypeBike = new Bike("PROTOTYPE", normalGPS);

        // 2. Leverage ArrayList API to store our cloned fleets
        // 串联全新API知识点：用 ArrayList 集合来装我们的单车车队
        ArrayList<Bike> shallowFleet = new ArrayList<>();
        ArrayList<Bike> deepFleet = new ArrayList<>();

        // 3. Batch cloning via loop
        // 通过循环，用两种方式各克隆 3 台车存入各自的车队
        for (int i = 1; i <= 3; i++) {
            shallowFleet.add(prototypeBike.shallowClone());
            deepFleet.add(prototypeBike.deepClone());
        }

        System.out.println("========== EMERGENCY SECURITY TEST (紧急安全测试) ==========");

        // =======================================================
        // SCENARIO 1: SHALLOW CLONE FAILS UNDER ATTACK
        // 实验一：浅克隆车队遭受劫持 —— 动一车而爆全城
        // =======================================================
        System.out.println("\n[Action] Changing GPS for Shallow-Bike 1 to 'HACKED!'...");
        // 仅仅修改浅克隆车队里第一台车 (Index 0)
        shallowFleet.get(0).updateGpsLocation("HACKED! (信号劫持!)");

        System.out.println("\n--- Shallow Clone Fleet Status (浅克隆车队现状) ---");
        for (Bike b : shallowFleet) {
            System.out.println(b.getBikeLog());
        }


        // =======================================================
        // SCENARIO 2: DEEP CLONE KEEPS DATA ISOLATED
        // 实验二：深克隆车队数据隔离 —— 独立修改互不干扰
        // =======================================================
        System.out.println("\n------------------------------------------------");
        System.out.println("[Action] Changing GPS for Deep-Bike 1 to 'Shibuya, Tokyo'...");
        // 仅仅修改深克隆车队里第一台车 (Index 0)
        deepFleet.get(0).updateGpsLocation("35.65, 139.70 (Shibuya, Tokyo)");

        System.out.println("\n--- Deep Clone Fleet Status (深克隆车队现状) ---");
        for (Bike b : deepFleet) {
            System.out.println(b.getBikeLog());
        }
    }
}
