package votingSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;

public class votingStatistics {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 🌟 核心：Key 存名字（String），Value 存票数（Integer）
            HashMap<String, Integer> voteMap = new HashMap<>();

            System.out.println("🏮 欢迎使用现代化 HashMap 计票系统（按 0 退出） 🏮");

            while (true) {
                System.out.println("\n请输入投票的名字：");
                String name = sc.next();
                if ("0".equals(name)) break;

                // 1. 闪电战：直接问鞋柜里有没有这个名字，零遍历，速度飞快！
                if (voteMap.containsKey(name)) {
                    // 2. 如果存在：先 get 出来老票数
                    int count = voteMap.get(name);
                    // 票数加 1，然后重新 put 进去覆盖老数据
                    voteMap.put(name, count + 1);
                } else {
                    // 3. 如果不存在：说明是新名字，直接开天辟地存入 1 票
                    voteMap.put(name, 1);
                    System.out.println("🆕 发现新面孔，已为您创建新账户！");
                }

                // 4. 利用昨晚刚学的 Lambda 一行流全自动打印战况
                System.out.println("--- 当前最新战况 ---");
                voteMap.forEach((k, v) -> System.out.println(k + " -> 当前票数: " + v));
            }
        }
    }