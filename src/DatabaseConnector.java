package com.tokyo.database;

import java.util.HashMap;
import java.util.Map;

public class DatabaseConnector {

    // 模拟本地临时账单缓存
    private static final Map<Integer, String> currentOrders = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("⚡ [2026-06-02] 正在初始化 MySQL 驱动连接池...");

        // 模拟连接配置
        String url = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        System.out.println("📡 已成功握手本地数据库: " + url + " [用户: " + user + "]");

        // 模拟今天新进来的两条居酒屋账单数据
        currentOrders.put(1001, "生啤 3杯 - 540 JPY");
        currentOrders.put(1002, "烤鸟串 1桶 - 1200 JPY");

        System.out.println("⏳ 正在启动向 student/order 表批量投喂数据流 (DML)...");

        // 模拟利用 JDBC 一行行写入数据库的过程
        currentOrders.forEach((id, detail) -> {
            System.out.println("➡️  EXECUTE SQL: INSERT INTO orders(id, detail) VALUES(" + id + ", '" + detail + "');");
            System.out.println("✅ 影响行数: 1行, 实时自增主键已安全绑定。");
        });

        System.out.println("📊 [2026-06-02] 本地缓存全部同步至 MySQL，高并发通道已自动 close 释放。");
    }
}
