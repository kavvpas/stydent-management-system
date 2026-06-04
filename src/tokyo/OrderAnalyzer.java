import com.tokyo.model.DishItem;
import java.util.ArrayList;
import java.util.List;

public class OrderAnalyzer {
    public static void main(String[] args) {
        List<DishItem> orderList = new ArrayList<>();
        orderList.add(new DishItem(1, "生啤酒", 540, "酒类"));
        orderList.add(new DishItem(2, "豪华烧鸟拼盘", 1500, "烧鸟"));
        orderList.add(new DishItem(3, "吟酿清酒", 1200, "酒类"));

        System.out.println("📊 正在使用 Stream 流统计高价值酒水订单...");

        // 过滤出单价超过 1000 日元的所有酒类，计算总金额
        double totalAlcoholPrice = orderList.stream()
                .filter(item -> "酒类".equals(item.getCategory()))
                .filter(item -> item.getPrice() >= 1000)
                .mapToDouble(DishItem::getPrice)
                .sum();

        System.out.println("✅ 统计完毕！高档酒水今日销售额: " + totalAlcoholPrice + " JPY");
    }
}