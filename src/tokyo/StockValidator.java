package tokyo;

public class StockValidator {
    public static void checkStock(String dishName, int requestCount, int currentStock) {
        System.out.println("⏳ 正在对菜品 [" + dishName + "] 进行高并发库存锁检测...");

        if (requestCount > currentStock) {
            // 抛出运行时异常，模拟被后厨拦截，防止乱单
            throw new IllegalArgumentException("🚨 核心警报：[" + dishName + "] 库存不足！剩余: " + currentStock);
        }

        System.out.println("✨ 安全通过！允许下发后厨出单。");
    }

    public static void main(String[] args) {
        try {
            checkStock("朝日生啤", 5, 2); // 模拟库存不够触发拦截
        } catch (IllegalArgumentException e) {
            System.out.println("🛡️ 异常拦截器成功捕获隐患: " + e.getMessage());
        }
    }
}
