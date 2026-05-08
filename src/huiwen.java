import java.util.Scanner;

public class huiwen {
    public static void main(String[] args){
        System.out.println("please enter a number:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 2; i < num; i++){
             int x = num % i;
             if (x == 0){
                 System.out.println("this is a FURE num");
                 break;
             }
        }

        System.out.println("this is a bad num");
    }
}
