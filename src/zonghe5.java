import java.util.Scanner;

public class zonghe5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("please enter the judges scores:");

            arr[i] = sc.nextInt();
        }
        int max = calculateHigh(arr);
        int min = calculateMin(arr);
        System.out.println("the max value is:"+ max);
        System.out.println("the min value is:"+ min);
    }
    public static int calculateHigh(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        return max;
    }
    public static int calculateMin(int arr[]){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
