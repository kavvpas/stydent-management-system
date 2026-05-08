import java.util.ArrayList;
import java.util.Scanner;

public class JavaReview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 创建一个抽屉
        ArrayList<String> companyList = new ArrayList<>();

        System.out.println("请输入你想去的东京IT公司（输入end结束）:");

        while(true) {
            String name = sc.next();
            if(name.equals("end")) break;

            // 把用户输入的东西，塞进这个智能抽屉里
            companyList.add(name);
        }

        System.out.println("你想去的公司共有 " + companyList.size() + " 家");
        System.out.println("名单如下: " + companyList);
    }
}