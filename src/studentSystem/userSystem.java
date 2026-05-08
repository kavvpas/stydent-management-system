package studentSystem;

import java.util.ArrayList;

public class userSystem {
    private String name;
    private String age;
    private String number;
    public void userMe(){

    }
    public userSystem(String name,String age,String number){
        this.name = name;
        this.age = age;
        this.number = number;
    }
    public static boolean check(ArrayList<userSystem> inf, String num){
        for (int i = 0; i < inf.size(); i++) {
            if(inf.get(i).getNumber().equals(num)){
               return true;
            }
        }
        return false;
    }

    public String getName() {
        return age;
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

