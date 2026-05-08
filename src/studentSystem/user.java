package studentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class user {
    public static void main(String[] args) {
        ArrayList<userSystem> inf = new ArrayList<>();
        loop:while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("welcome to information system");
            System.out.println("1.add");
            System.out.println("2.delete");
            System.out.println("3.change");
            System.out.println("4.find");
            System.out.println("5.quid");
            System.out.println("please enter number:");
            int cho = sc.nextInt();
            switch (cho) {
                case 1:
                    System.out.println("please enter: name age number");
                    String name = sc.next();
                    String age = sc.next();
                    String number = sc.next();

                    // 2. 拿到学号后立刻查重
                    if (userSystem.check(inf, number)) {
                        System.out.println("the information already exists!");
                    } else {
                        inf.add(new userSystem(name, age, number));
                        System.out.println("added successfully!");
                    }
                    break;
                case 2:
                    System.out.println("please enter information:");
                    String infD = sc.next();
                    for (int i = 0; i < inf.size(); i++) {
                        if (userSystem.check(inf, infD)) {
                            inf.remove(i);
                            System.out.println("the information has been deleted");
                            break;
                        } else {
                            System.out.println("the information does not exist");
                        }
                    }
                    break ;
                case 3:
                    System.out.println("please enter information:");
                    String infC = sc.next();
                    for (int i = 0; i < inf.size(); i++) {
                        if (userSystem.check(inf, infC)) {
                            System.out.println("please enter new name information:");
                            String newName = sc.next();
                            inf.get(i).setName(newName);
                            System.out.println("please enter new age information");
                            String newAge = sc.next();
                            inf.get(i).setName(newAge);
                            break;
                        } else {
                            System.out.println("the information dose not exit");
                        }
                    }
                    break ;
                case 4:
                    System.out.println("please enter information:");
                    String infF = sc.next();
                    for (int i = 0; i < inf.size(); i++) {
                        if (userSystem.check(inf, infF)) {
                            System.out.println("the information is :" + inf.get(i).getName() + inf.get(i).getAge() + inf.get(i).getNumber());
                            break;
                        } else {
                            System.out.println("the information dose not exit");
                        }
                    }
                    break ;
                case 5:
                    System.out.println("退出成功！");
                    return;
            }
        }
    }
}
