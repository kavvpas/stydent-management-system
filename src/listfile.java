import java.io.File;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class listfile {
    public static HashMap<String, Integer> tatal = new HashMap<>();
    public static void main(String[] args) {
        File file = new File("src/tokyo_bar");
        File[] files = file.listFiles();
        Listfile(file);

    }

    public static void Listfile(File dir){

        File[] files = dir.listFiles();

        //  关键卡点：第一步判断是不是 null，第二步判断它是不是个空箱子
        if (files != null && files.length > 0) {

            // 只有安全通过上面两道防线，才允许增强 for 循环入场！
            for (File listFile : files) {
                if (listFile.isDirectory()) {
                    Listfile(listFile);
                }
                else {String fileName = listFile.getName(); // 比如 "today.png"

                // 防呆拦截：万一有的文件没有后缀名（名字里没有“.”）
                if (fileName.contains(".")) {
                    String type = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                    // 找不到就存1，找到了就把老票数 + 1
                    tatal.merge(type, 1, (oldValue, newValue) -> oldValue + 1);
                } else {
                    // 实在没有后缀名的，统一归类到未知文件
                    tatal.merge("未知类型", 1, (oldValue, newValue) -> oldValue + 1);
                }
                System.out.println("文件：" + listFile.getName());
                }
            }

        } else {
            System.out.println("⚠️ 警报：文件夹不存在、或者里面空空如也！已经成功拦截闪退风险！");
        }

    }
}
