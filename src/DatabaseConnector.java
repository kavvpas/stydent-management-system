import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
    public static void main(String[] args) {
        // 模拟 JDBC 驱动配置与本地 test_db 连接
        String url = "jdbc:mysql://localhost:3306/test_db";
        System.out.println("📡 SUCCESS: Connected to " + url);

        // 模拟今天新进来的居酒屋加急账单流水
        List<String> mockSqlBatch = new ArrayList<>();
        mockSqlBatch.add("INSERT INTO student (name, age, major) VALUES ('张三', 23, 'Big Data');");
        mockSqlBatch.add("INSERT INTO student (name, age, major) VALUES ('李四', 22, 'Computer');");

        // 模拟全自动批量执行 DML 数据投喂
        for (String sql : mockSqlBatch) {
            System.out.println("⚡ [EXECUTE] -> " + sql);
            System.out.println("📊 Result: 1 row affected.");
        }
    }
}