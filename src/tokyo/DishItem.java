package tokyo;

public class DishItem {
    private int id;
    private String name;
    private double price;
    private String category; // 菜品分类：如 "酒类", "烧鸟", "主食"

    public DishItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}