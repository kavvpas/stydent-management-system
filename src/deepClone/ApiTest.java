package deepClone;

import java.util.Random;

public class ApiTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 串联 Random API: 随机生成一个单车编号
        Random r = new Random();
        String bikeId = "BK-" + (r.nextInt(9000) + 1000); // 1000~9999

        // Create original bike with a GPS device
        // 创建一台拥有GPS的原始单车
        GPS originalGPS = new GPS("35.72, 139.65 (Nerima, Tokyo)");
        Bike originalBike = new Bike(bikeId, originalGPS);

        System.out.println("--- Original Bike Status ---");
        System.out.println(originalBike.getBikeLog());

        // ==========================================
        // SCENARIO 1: SHALLOW CLONE (浅克隆实验)
        // ==========================================
        Bike shallowBike = originalBike.shallowClone();

        // CRITICAL PROOF: Do they share the same GPS memory address?
        // 核心证明：它们是不是共享同一个GPS的内存地址？
        System.out.println("\n[Shallow Clone Check]");
        System.out.println("Same Bike Object? (单车对象是同一个吗？) -> " + (originalBike == shallowBike));
        System.out.println("Same GPS Object? (GPS对象是同一个吗？) -> " + (originalBike.getGps() == shallowBike.getGps()));
        // Result is TRUE! If you change shallowBike's GPS, originalBike will ALSO change!
        // 结果是 true！如果你改了克隆车的GPS，原车的GPS也会跟着变！(这就是浅克隆的隐患)

        // ==========================================
        // SCENARIO 2: DEEP CLONE (深克隆实验)
        // ==========================================
        Bike deepBike = originalBike.deepClone();

        System.out.println("\n[Deep Clone Check]");
        System.out.println("Same Bike Object? (单车对象是同一个吗？) -> " + (originalBike == deepBike));
        System.out.println("Same GPS Object? (GPS对象是同一个吗？) -> " + (originalBike.getGps() == deepBike.getGps()));
        // Result is FALSE! They are completely independent in memory now!
        // 结果是 false！它们在内存中彻底独立了！改新车，原车完全不受影响！
    }
}
