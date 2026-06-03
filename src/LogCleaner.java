
import java.io.File;
import java.util.Arrays;

public class LogCleaner {
    public static void main(String[] args) {
        File logDir = new File("src/tokyo_bar/logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File[] files = logDir.listFiles();
        if (files != null) {
            // 🌟 极简一行流：利用 Stream 快速筛选并清理包含 "temp" 的过期日志
            Arrays.stream(files)
                    .filter(File::isFile)
                    .filter(f -> f.getName().endsWith(".log") && f.getName().contains("temp"))
                    .forEach(File::delete); // 查到直接全自动物理删除
        }
    }
}
