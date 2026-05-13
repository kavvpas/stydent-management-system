package BIKE;

public class BikeSystem {
    public static void main(String[] args) {
        // Use a Polymorphic Array to store different types of bikes
        // 使用多态数组，一个数组里既能存普通车，也能存电动车
        Bike[] fleet = new Bike[2];
        fleet[0] = new Bike("HelloCycling");
        fleet[1] = new ElectricBike("DocomoBike", 85);

        // Process all bikes using a single loop
        // 只用一个循环处理所有车，这就是多态的强大之处
        for (int i = 0; i < fleet.length; i++) {
            fleet[i].unlock();
        }
    }
}