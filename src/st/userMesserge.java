package st;

public class userMesserge {
    private String name;
    private String age;
    private String number;
    public void userMe(){

    }
    public userMesserge(String name,String age,String number){
       this.name = name;
       this.age = age;
       this.number = number;
    }
    public static boolean check(userMesserge[] stru, String num) {
        // 1. 假设一开始没找到，默认是 true (或者根据你的业务逻辑设定)
        boolean exists = false;

        for (int i = 0; i < stru.length; i++) {
            // 2. 严谨判断：防止格子里是空的（null）导致报错
            if (stru[i] != null) {
                // 3. 使用 .equals() 比较字符串内容
                if (stru[i].getName().equals(num)) {
                    exists = true;
                    break; // 既然找到了，就没必要继续往下翻柜子了，直接跳出循环
                }
            }
        }
        // 4. 整个柜子翻完了，最后统一返回结果
        return exists;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getNumber() {
        return number;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
