package BIKE;

public class Bike {
        private String brand;

        public Bike(String brand) {
            this.brand = brand;
        }

        // Common action for all bikes
        // 所有单车的通用动作：解锁
        public void unlock() {
            System.out.println(brand + " bike is unlocked. (单车已解锁)");
        }

        public String getBrand() { return brand; }
}
