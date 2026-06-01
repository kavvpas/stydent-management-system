package com.tokyo.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogCleaner {
    public static void main(String[] args) {
        System.out.println("🔧 [2026-06-01] 启动历史日志扫描归档系统...");

        // 模拟一个日志文件夹
        File logDir = new File("src/tokyo_bar/logs");

        // 如果不存在就模拟创建一下
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File[] files = logDir.listFiles();

        if (files != null && files.length > 0) {
            // 🌟 昨天刚练熟的 Stream 流降维打击
            List<File> expiredLogs = Arrays.stream(files)
                    .filter(File::isFile)
                    .filter(file -> file.getName().endsWith(".log"))
                    // 模拟过滤：筛选出包含 "temp" 或者 "cache" 的过期临时日志
                    .filter(file -> file.getName().contains("temp") || file.getName().contains("cache"))
                    .collect(Collectors.toList());

            System.out.println("📊 扫描完毕！共发现 " + expiredLogs.size() + " 个可清理的临时日志文件。");

            // 模拟安全清理
            expiredLogs.forEach(file -> System.out.println("🗑️ 已全自动安全释放: " + file.getName()));
        } else {
            System.out.println("✨ 文件夹空空如也，无需清理！");
        }
        System.out.println("🎉 [2026-06-01] 日志清理模块全盘闭环。");
    }
}
