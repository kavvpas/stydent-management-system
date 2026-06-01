import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class tatol {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/raw_bill");
        if (file.exists()){
            String filepath = "src/raw_bill";
            ArrayList<String> validLines = new ArrayList<>();
            try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                // 2. 一行一行读
                while ((line = br.readLine()) != null) {


                    // 过滤条件1：如果是空行，直接跳过 (trim() 可以去掉空格)
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    // 过滤条件2：如果包含敏感词“测试”，直接跳过
                    if (line.contains("未成年")) {
                        continue;
                    }
                    validLines.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String dirPath = "src/new_dir";              // 新文件夹
            String filePath = dirPath + "/clean_bill.txt"; // 新文件路径

            // 2. 创建文件夹对象，并检查是否存在
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs(); // mkdirs() 可以创建多级文件夹，黑马必背方法！
                System.out.println("检测到文件夹不存在，已自动创建：" + dirPath);
            }

            // 3. 使用 BufferedWriter 核心外挂，套上 FileWriter 这根核心写出吸管
            // try-with-resources 会自动帮我们 flush(刷新) 和 close(关闭)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

                // 4. 遍历集合，把内容一行行写进去
                for (String content : validLines) {
                    bw.write(content);
                    bw.newLine();
                }

                System.out.println("数据已成功保存到新文件：" + filePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new FileNotFoundException("错误：找不到指定的文件 " + file.getAbsolutePath());
        }
    }
}
