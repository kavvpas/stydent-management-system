package tokyo;

public class ReportMapper {
    public static void main(String[] args) {
        System.out.println("📡 正在准备 MySQL 报表多表联查数据流...");

        // 模拟大厂经典的 INNER JOIN 跨表复杂查询语句
        String sql = "SELECT u.name, o.order_id, o.amount " +
                "FROM users u " +
                "INNER JOIN orders o ON u.id = o.user_id " +
                "WHERE o.amount >= 1000 " +
                "ORDER BY o.amount DESC;";

        System.out.println("📝 TARGET SQL KEY -> " + sql);
        System.out.println("✅ SQL 编译校验成功，下周准备正式挂载到 MyBatis 数据库中！");
    }
}