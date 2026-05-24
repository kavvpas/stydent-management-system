import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class shuzu {
    public static void main(String[] args) {
        System.out.println("please inter arr:");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("tom");
        list.add(sc.next());
        String list2 = " hello world ";
        Iterator<String> it = list.iterator();
        String list3 = list2.replace(" ","");
    }
}