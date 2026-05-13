package BIKE;

public class ElectricBike extends Bike {
    private int battery;

    public ElectricBike(String brand, int battery) {
        super(brand);
        this.battery = battery;
    }

    // Override the unlock method to show battery status
    // 重写解锁方法，额外显示电量状态
    @Override
    public void unlock() {
        System.out.println(getBrand() + " Electric bike unlocked. Battery: " + battery + "%. (助力车解锁，剩余电量：" + battery + "%)");
    }
}