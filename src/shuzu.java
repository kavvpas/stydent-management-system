import java.util.Scanner;

public class shuzu {
    public static void main(String[] args){
        System.out.println("please inter arr:");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= sc.nextInt();
        }

    }
}
